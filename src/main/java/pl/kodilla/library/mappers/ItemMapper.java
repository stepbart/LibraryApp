package pl.kodilla.library.mappers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.kodilla.library.domain.Item;
import pl.kodilla.library.dto.ItemDto;
import pl.kodilla.library.repositories.BookRepository;
import pl.kodilla.library.repositories.BorrowRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ItemMapper {

    private final BookRepository bookRepository;
    private final BorrowRepository borrowRepository;

    public Item mapItemDtoToItem(final ItemDto itemDto){
        return new Item(
                itemDto.getId(),
                itemDto.getStatus(),
                bookRepository.findById(itemDto.getBookId()).orElse(null),
                itemDto.getBorrowsIdList().stream().map(x -> borrowRepository.findById(x).orElseThrow()).collect(Collectors.toList()));
    }

    public ItemDto mapItemToItemDto(final Item item){
        return new ItemDto(
                item.getId(),
                item.getStatus(),
                item.getBook().getId(),
                item.getItemBorrows().stream().map(x -> x.getId()).collect(Collectors.toList()));
    }

    public List<ItemDto> mapToItemDtoList(List<Item> items){
        return items.stream().map(this::mapItemToItemDto).collect(Collectors.toList());
    }
}
