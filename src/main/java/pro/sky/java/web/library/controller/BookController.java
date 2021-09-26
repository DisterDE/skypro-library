package pro.sky.java.web.library.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.web.library.entity.Book;
import pro.sky.java.web.library.service.BookService;

import java.util.Set;

@RestController
@RequestMapping("book")
public class BookController {

    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    // http://localhost:8080/library/book/add?name=WarAndPeace4&authorFirstName=Lev&authorLastName=Tolstoy&publishingYear=1870
    @GetMapping("add")
    public Book addBook(
            @RequestParam String name,
            @RequestParam String authorFirstName,
            @RequestParam String authorLastName,
            @RequestParam int publishingYear
    ) {
        return service.addBook(name, authorFirstName, authorLastName, publishingYear);
    }

    // http://localhost:8080/library/book/remove?bookName=WarAndPeace
    @GetMapping("remove")
    public boolean removeBook(@RequestParam String bookName) {
        return service.delete(bookName);
    }

    // http://localhost:8080/library/book/all
    @GetMapping("all")
    public Iterable<Book> getAllBooks() {
        return service.findAll();
    }

    // http://localhost:8080/library/book/find?publishingYear=1978
    // http://localhost:8080/library/book/find?bookName=Romeo%20and%20Juliet
    @GetMapping("find")
    public Iterable<Book> find(@RequestParam(required = false) String bookName, @RequestParam(required = false) Integer publishingYear) {
        if (bookName != null) {
            return Set.of(service.findByName(bookName));
        }
        if (publishingYear != null) {
            return service.findAllByPublishingYear(publishingYear);
        }
        return null;
    }
}
