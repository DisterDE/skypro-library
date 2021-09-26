package pro.sky.java.web.library.bootstrap;

import org.springframework.stereotype.Component;
import pro.sky.java.web.library.service.AuthorService;
import pro.sky.java.web.library.service.BookService;

@Component
public class Bootstrap {

    private final AuthorService authorService;
    private final BookService bookService;

    public Bootstrap(AuthorService authorService, BookService bookService) {
        this.authorService = authorService;
        this.bookService = bookService;
    }

    public void addAuthors() {
        authorService.addAuthor("Lev", "Tolstoy");
        authorService.addAuthor("Stephen", "King");
        authorService.addAuthor("William", "Shakespeare");
    }

    public void addBooks() {
        bookService.addBook("War and Peace", "Lev", "Tolstoy", 1867);
        bookService.addBook("The Stand", "Stephen", "King", 1978);
        bookService.addBook("Romeo and Juliet", "William", "Shakespeare", 1597);
    }
}
