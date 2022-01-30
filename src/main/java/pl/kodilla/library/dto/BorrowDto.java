package pl.kodilla.library.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class BorrowDto {

    private Long id;
    private LocalDateTime borrowed;
    private LocalDateTime returned;

}
