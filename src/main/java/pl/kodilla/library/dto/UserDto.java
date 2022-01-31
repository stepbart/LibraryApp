package pl.kodilla.library.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.kodilla.library.domain.Borrow;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@AllArgsConstructor
public class UserDto {

    private Long id;
    private String firstName;
    private String secondName;
    private LocalDateTime created;
    private List<Borrow> userBorrows;
}
