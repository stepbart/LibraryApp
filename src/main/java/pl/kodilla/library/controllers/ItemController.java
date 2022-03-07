package pl.kodilla.library.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.kodilla.library.domain.Item;
import pl.kodilla.library.dto.ItemDto;
import pl.kodilla.library.mappers.ItemMapper;
import pl.kodilla.library.services.ItemService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1.0/items")
public class ItemController {

    private final ItemService itemService;
    private final ItemMapper itemMapper;

    @PostMapping
    public ResponseEntity<ItemDto> addItem(@RequestBody ItemDto itemDto){
        Item item = itemMapper.mapItemDtoToItem(itemDto);
        Item savedItem = itemService.addItem(item);
        return ResponseEntity.ok(itemMapper.mapItemToItemDto(savedItem));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItemDto> changeItemStatus(@PathVariable("id") Long itemId, @RequestParam Integer statusNumber){
        return ResponseEntity.ok(itemMapper.mapItemToItemDto(itemService.changeStatus(itemId,statusNumber)));
    }
}
