package pro.sky.java.web.library.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pro.sky.java.web.library.entity.Book;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
    Book findByName(String name);

    List<Book> findByPublishingYear(int publishingYear);

    boolean deleteByName(String name);

    boolean existsByName(String name);
}