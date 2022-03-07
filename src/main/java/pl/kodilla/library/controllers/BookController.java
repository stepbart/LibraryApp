package pl.kodilla.library.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpCookie;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.kodilla.library.domain.Book;
import pl.kodilla.library.dto.BookDto;
import pl.kodilla.library.dto.ItemDto;
import pl.kodilla.library.exceptions.ItemNotFoundException;
import pl.kodilla.library.mappers.BookMapper;
import pl.kodilla.library.mappers.ItemMapper;
import pl.kodilla.library.services.BookService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1.0/books")
public class BookController {

    private final BookService bookService;
    private final BookMapper bookMapper;
    private final ItemMapper itemMapper;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BookDto> addBook(@RequestBody BookDto bookDto){
        Book book = bookMapper.mapBookDtoToBook(bookDto);
        Book savedBook = bookService.addBook(book);
        return ResponseEntity.ok(bookMapper.mapBookToBookDto(savedBook));
    }

    @GetMapping("/{id}/items")
    public ResponseEntity<List<ItemDto>> getAllItems(@PathVariable("id") Long bookId) throws ItemNotFoundException {
        return new ResponseEntity<>(itemMapper.mapToItemDtoList(bookService.getItems(bookId)), HttpStatus.OK);
    }
}
