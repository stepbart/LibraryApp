package pl.kodilla.library.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.kodilla.library.enums.Status;

import java.util.List;

@Getter
@AllArgsConstructor
public class ItemDto {

    private Long id;
    private Status status;
    private Long bookId;
    private List<Long> borrowsIdList;
}
