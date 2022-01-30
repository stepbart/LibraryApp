package pl.kodilla.library.domain;

import lombok.*;
import pl.kodilla.library.enums.Status;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "ITEMS")
public class Item {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    private Long id;
    private Status status;

    @ManyToOne
    @JoinColumn(name = "items")
    private Book book;

    @OneToMany(
            targetEntity = Borrow.class,
            mappedBy = "item",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Borrow> itemBorrows;
}
