package pl.kodilla.library.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.kodilla.library.domain.User;
import pl.kodilla.library.repositories.UserRepository;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public User addUser(User user) {
        user.setCreated(LocalDateTime.now());
        return userRepository.save(user);
    }
}
