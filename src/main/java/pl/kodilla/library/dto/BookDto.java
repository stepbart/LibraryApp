package pl.kodilla.library.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.kodilla.library.domain.Item;

import java.time.LocalDate;
import java.util.List;

@Getter
@AllArgsConstructor
public class BookDto {

    private Long id;
    private String title;
    private String author;
    private LocalDate published;
    private List<Item> items;
}
