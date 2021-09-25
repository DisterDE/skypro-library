package pro.sky.java.web.library.service;

import pro.sky.java.web.library.domain.Author;
import pro.sky.java.web.library.domain.Book;
import pro.sky.java.web.library.repository.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private final BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public boolean addBook(String bookName, String authorFirstName, String authorLastName, int publishingYear) {
        Author author = new Author(authorFirstName, authorLastName);
        Book book = new Book(bookName, author, publishingYear);
        return repository.addBook(book);
    }

    public boolean removeBook(String bookName) {
        return repository.removeBook(bookName);
    }

    public String printBooks() {
        return repository.printAllBooks();
    }
}
