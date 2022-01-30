package pl.kodilla.library.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
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
    @JoinColumn(name = "itemBorrows")
    private Item item;

    @ManyToOne
    @JoinColumn(name = "userBorrows")
    private User user;
}
