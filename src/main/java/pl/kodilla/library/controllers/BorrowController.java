package pl.kodilla.library.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.kodilla.library.dto.BorrowDto;
import pl.kodilla.library.mappers.BookMapper;
import pl.kodilla.library.mappers.BorrowMapper;
import pl.kodilla.library.services.BorrowService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1.0/borrows")
public class BorrowController {

    private final BorrowService borrowService;
    private final BorrowMapper borrowMapper;

    @PostMapping
    public ResponseEntity<BorrowDto> borrowBook(@RequestParam Long itemId, @RequestParam Long userId){
        return ResponseEntity.ok(borrowMapper.mapBorrowToBorrowDto(borrowService.createNewBorrow(itemId,userId)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BorrowDto> returnBook(@PathVariable("id") Long borrowId){
        return ResponseEntity.ok(borrowMapper.mapBorrowToBorrowDto(borrowService.returnBook(borrowId)));
    }
}
