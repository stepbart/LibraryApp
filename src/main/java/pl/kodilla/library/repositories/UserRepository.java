package pl.kodilla.library.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.kodilla.library.domain.User;

import java.util.List;

@Transactional
@Repository
public interface UserRepository extends CrudRepository<User,Long> {

    List<User> findAll();
}
