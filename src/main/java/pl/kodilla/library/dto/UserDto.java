package pl.kodilla.library.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class UserDto {

    private Long id;
    private String firstName;
    private String secondName;
    private LocalDateTime created;
}
