package pl.kodilla.library.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.kodilla.library.domain.Borrow;
import pl.kodilla.library.domain.Item;

import java.util.List;

@Transactional
@Repository
public interface BorrowRepository extends CrudRepository<Borrow,Long> {

    List<Borrow> findAll();
}
