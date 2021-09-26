package pro.sky.java.web.library.service;

import org.springframework.stereotype.Service;
import pro.sky.java.web.library.entity.Author;
import pro.sky.java.web.library.entity.Book;
import pro.sky.java.web.library.repository.BookRepository;

@Service
public class BookService {

    private final BookRepository repository;
    private final AuthorService authorService;

    public BookService(BookRepository repository, AuthorService authorService) {
        this.repository = repository;
        this.authorService = authorService;
    }

    public Book addBook(String bookName, String authorFirstName, String authorLastName, int publishingYear) {
        if (existsByName(bookName)) {
            return repository.findByName(bookName);
        }
        Author author = authorService.addAuthor(authorFirstName, authorLastName);
        Book book = new Book(bookName, publishingYear, author);
        return repository.save(book);
    }

    public boolean removeBook(String bookName) {
        return repository.deleteByName(bookName);
    }

    public Iterable<Book> getAll() {
        return repository.findAll();
    }

    public Iterable<Book> getAllByPublishingYear(int publishingYear) {
        return repository.findByPublishingYear(publishingYear);
    }

    public Book findByName(String bookName) {
        return repository.findByName(bookName);
    }

    public boolean existsByName(String bookName) {
        return repository.existsByName(bookName);
    }
}
