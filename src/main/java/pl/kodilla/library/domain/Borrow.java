package pl.kodilla.library.domain;

import lombok.*;
import pl.kodilla.library.enums.Status;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "BORROWS")
public class Borrow {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    private Long id;
    private LocalDateTime borrowed;
    private LocalDateTime returned;

    @ManyToOne
    @JoinColumn(name = "ITEM_ID")
    private Item item;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    public void returnBook(){
        this.returned = LocalDateTime.now();
        this.item.setStatus(Status.FREE);
    }
}
