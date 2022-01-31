package pl.kodilla.library.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.kodilla.library.domain.Borrow;
import pl.kodilla.library.enums.Status;
import pl.kodilla.library.repositories.BorrowRepository;
import pl.kodilla.library.repositories.ItemRepository;
import pl.kodilla.library.repositories.UserRepository;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class BorrowService {

    private final BorrowRepository borrowRepository;
    private final ItemRepository itemRepository;
    private final UserRepository userRepository;

    public Borrow createNewBorrow(Long itemId, Long userId) {
        Borrow borrow = new Borrow();
        borrow.setItem(itemRepository.findById(itemId).orElseThrow());
        borrow.getItem().setStatus(Status.BORROWED);
        borrow.setUser(userRepository.findById(userId).orElseThrow());
        borrow.setBorrowed(LocalDateTime.now());
        return borrowRepository.save(borrow);
    }

    public Borrow returnBook(Long borrowId) {
        Borrow borrow = borrowRepository.findById(borrowId).orElseThrow();
        borrow.getItem().setStatus(Status.FREE);
        borrow.setReturned(LocalDateTime.now());
        return borrowRepository.save(borrow);
    }
}
