package pl.kodilla.library.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.kodilla.library.domain.Book;
import pl.kodilla.library.domain.Item;
import pl.kodilla.library.exceptions.ItemNotFoundException;
import pl.kodilla.library.repositories.BookRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    @Transactional
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    @Transactional
    public List<Item> getItems(Long bookId) throws ItemNotFoundException {
        Book book = bookRepository.findById(bookId).orElseThrow(ItemNotFoundException::new);
        return book.getItems();
    }
}
