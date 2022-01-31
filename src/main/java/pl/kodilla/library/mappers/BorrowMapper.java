package pl.kodilla.library.mappers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.kodilla.library.domain.Borrow;
import pl.kodilla.library.dto.BorrowDto;
import pl.kodilla.library.repositories.ItemRepository;
import pl.kodilla.library.repositories.UserRepository;

@Service
@RequiredArgsConstructor
public class BorrowMapper {

    private final ItemRepository itemRepository;
    private final UserRepository userRepository;

    public Borrow mapBorrowDtoToBorrow(final BorrowDto borrowDto){
        return new Borrow(
                borrowDto.getId(),
                borrowDto.getBorrowed(),
                borrowDto.getReturned(),
                itemRepository.findById(borrowDto.getItemId()).orElseThrow(),
                userRepository.findById(borrowDto.getUserId()).orElseThrow());
    }

    public BorrowDto mapBorrowToBorrowDto(final Borrow borrow){
        return new BorrowDto(
                borrow.getId(),
                borrow.getBorrowed(),
                borrow.getReturned(),
                borrow.getItem().getId(),
                borrow.getUser().getId());
    }
}
