package pl.kodilla.library;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.kodilla.library.domain.Book;
import pl.kodilla.library.domain.Borrow;
import pl.kodilla.library.domain.Item;
import pl.kodilla.library.domain.User;
import pl.kodilla.library.enums.Status;
import pl.kodilla.library.repositories.BookRepository;
import pl.kodilla.library.repositories.BorrowRepository;
import pl.kodilla.library.repositories.ItemRepository;
import pl.kodilla.library.repositories.UserRepository;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class LibraryTestSuite {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private BorrowRepository borrowRepository;

    @Test
    public void userCrudTest(){
        //Given
        User user = new User("Marian","Krzyczkowski");

        //When
        userRepository.save(user);
        Long userId = user.getId();

        //Then
        List<User> userList = userRepository.findAll();
        assertEquals(1,userList.size());
        assertEquals("Marian",userRepository.findById(userId).get().getFirstName());
        assertEquals("Krzyczkowski",userRepository.findById(userId).get().getSecondName());

        //Clean Up
        userRepository.deleteById(userId);
    }

    @Test
    public void BookCrudTest(){
        //Given
        Book book = new Book("Solaris","Stanisław Lem", LocalDate.of(1961,06,01));
        Item item1 = new Item(Status.FREE,book);
        Item item2 = new Item(Status.FREE,book);
        Item item3 = new Item(Status.FREE,book);
        book.addItem(item1);
        book.addItem(item2);
        book.addItem(item3);

        //When
        bookRepository.save(book);
        Long bookId = book.getId();
        Long item1Id = item1.getId();

        //Then
        List<Book> bookList = bookRepository.findAll();
        assertEquals(1,bookList.size());
        assertEquals("Solaris",bookRepository.findById(bookId).get().getTitle());
        assertEquals("Stanisław Lem",bookRepository.findById(bookId).get().getAuthor());
        assertEquals(3,bookRepository.findById(bookId).get().getItems().size());
        assertEquals(book.getId(),itemRepository.findById(item1Id).get().getBook().getId());

        //Clean Up
        bookRepository.deleteById(bookId);
    }

    @Test
    public void itemCrudTest(){
        //Given
        Book book = new Book("Solaris","Stanisław Lem", LocalDate.of(1961,06,01));
        Item item1 = new Item(Status.FREE,book);
        Item item2 = new Item(Status.BORROWED,book);
        book.addItem(item1);
        book.addItem(item2);

        //When
        bookRepository.save(book);
        itemRepository.save(item1);
        itemRepository.save(item2);
        Long itemId1 = item1.getId();
        Long itemId2 = item2.getId();
        Long bookId = book.getId();

        //Then
        List<Item> itemList = itemRepository.findAll();
        assertEquals(2,itemList.size());
        assertEquals(2,bookRepository.findById(bookId).get().getItems().size());
        assertEquals(book.getId(),itemRepository.findById(itemId1).get().getBook().getId());
        assertEquals(book.getId(),itemRepository.findById(itemId2).get().getBook().getId());

        //Clean Up
        itemRepository.deleteById(itemId2);
        itemRepository.deleteById(itemId1);
        bookRepository.deleteById(bookId);
    }

    @Test
    public void BorrowCrudTest(){
        //Given
        User user = new User("Marian","Krzyczkowski");
        userRepository.save(user);
        Book book = new Book("Solaris","Stanisław Lem", LocalDate.of(1961,06,01));
        bookRepository.save(book);
        Item item = new Item(Status.FREE,book);
        itemRepository.save(item);
        book.addItem(item);

        Borrow borrow = new Borrow();
        borrowRepository.save(borrow);
        item.getItemBorrows().add(borrow);
        user.getUserBorrows().add(borrow);
        borrow.setItem(item);
        borrow.setUser(user);

        //When
        borrowRepository.save(borrow);
        Long borrowId = borrow.getId();
        Long itemId = item.getId();
        Long userId = user.getId();
        Long bookId = book.getId();

        //Then
        List<Borrow> borrowList = borrowRepository.findAll();
        assertEquals(1,borrowList.size());
        assertEquals("Marian",borrowRepository.findById(borrowId).get().getUser().getFirstName());
        assertEquals("Solaris",borrowRepository.findById(borrowId).get().getItem().getBook().getTitle());

        //Clean Up
        borrowRepository.deleteById(borrow.getId());
        itemRepository.deleteById(itemId);
        bookRepository.deleteById(bookId);
        userRepository.deleteById(userId);

    }
}
