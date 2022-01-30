package pl.kodilla.library.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.kodilla.library.domain.Book;

@RestController
@RequestMapping("/books")
public class BookController {

    @PostMapping("/addBook")
    public ResponseEntity addBook(@RequestBody Book book){
        System.out.println("Book added");
        return new ResponseEntity(book,HttpStatus.OK);
    }

    @GetMapping("/{id}/items")
    public ResponseEntity getAllItems(@PathVariable("id") Long bookId){
        System.out.println("Items gotten");
        return new ResponseEntity(HttpStatus.OK);
    }
}
