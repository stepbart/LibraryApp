package pl.kodilla.library.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/borrows")
public class BorrowController {

    @PostMapping("/borrowBook")
    public ResponseEntity borrowBook(@RequestParam Long itemId, @RequestParam Long userId){
        System.out.println("Book borrowed");
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity returnBook(@PathVariable("id") Long borrowId){
        System.out.println("Book returned");
        return new ResponseEntity(borrowId,HttpStatus.OK);
    }
}
