package pl.kodilla.library.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.kodilla.library.domain.Item;

@RestController
@RequestMapping("/items")
public class ItemController {

    @PostMapping("/addItem")
    public ResponseEntity addItem(@RequestBody Item item){
        System.out.println("Item added");
        return new ResponseEntity(item, HttpStatus.OK);
    }

    @PutMapping("/{id}/changeStatus")
    public ResponseEntity changeItemStatus(@PathVariable("id") Long itemId, @RequestParam Integer statusNumber){
        System.out.println("Status changed");
        return new ResponseEntity(statusNumber,HttpStatus.OK);
    }
}
