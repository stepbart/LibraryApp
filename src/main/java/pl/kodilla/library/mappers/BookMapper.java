package pl.kodilla.library.mappers;

import org.springframework.stereotype.Service;
import pl.kodilla.library.domain.Book;
import pl.kodilla.library.dto.BookDto;

@Service
public class BookMapper {

    public Book mapBookDtoToBook(final BookDto bookDto){
        return new Book(
                bookDto.getId(),
                bookDto.getTitle(),
                bookDto.getAuthor(),
                bookDto.getPublished(),
                bookDto.getItems());
    }

    public BookDto mapBookToBookDto(final Book book){
        return new BookDto(
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getPublished(),
                book.getItems());
    }
}
