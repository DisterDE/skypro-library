package pro.sky.java.web.library.service;

import org.springframework.stereotype.Service;
import pro.sky.java.web.library.entity.Author;
import pro.sky.java.web.library.repository.AuthorRepository;

@Service
public class AuthorService {

    private final AuthorRepository repository;

    public AuthorService(AuthorRepository repository) {
        this.repository = repository;
    }

    public Author add(String firstName, String lastName) {
        if (existsByFirstNameAndLastName(firstName, lastName)) {
            return findByFirstNameAndLastName(firstName, lastName);
        }
        Author author = new Author(firstName, lastName);
        return repository.save(author);
    }

    public Author findByFirstNameAndLastName(String firstName, String lastName) {
        return repository.findByFirstNameAndLastName(firstName, lastName);
    }

    public boolean existsByFirstNameAndLastName(String firstName, String lastName) {
        return repository.existsByFirstNameAndLastName(firstName, lastName);
    }

    public Iterable<Author> findAll() {
        return repository.findAll();
    }

    public Iterable<Author> findByLastName(String lastName) {
        return repository.findByLastName(lastName);
    }
}
