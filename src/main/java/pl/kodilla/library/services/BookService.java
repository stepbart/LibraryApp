package pl.kodilla.library.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.kodilla.library.domain.Book;
import pl.kodilla.library.domain.Item;
import pl.kodilla.library.repositories.BookRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public List<Item> getItems(Long bookId) {
        Book book = bookRepository.findById(bookId).orElseThrow();
        return book.getItems();
    }
}
