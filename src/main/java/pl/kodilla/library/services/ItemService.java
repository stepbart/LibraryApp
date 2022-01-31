package pl.kodilla.library.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.kodilla.library.domain.Item;
import pl.kodilla.library.enums.Status;
import pl.kodilla.library.repositories.ItemRepository;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    public Item addItem(Item item) {
        item.setStatus(Status.FREE);
        return itemRepository.save(item);
    }

    public Item changeStatus(Long itemId, Integer statusNumber) {
        Item item = itemRepository.findById(itemId).orElseThrow();
        Status status = Status.getStatus(statusNumber);
        item.setStatus(status);
        return itemRepository.save(item);
    }
}
