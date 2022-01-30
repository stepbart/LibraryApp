package pl.kodilla.library.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.kodilla.library.domain.Book;
import pl.kodilla.library.domain.Item;

import java.util.List;

@Transactional
@Repository
public interface ItemRepository extends CrudRepository<Item,Long> {

    List<Item> findAll();
}
