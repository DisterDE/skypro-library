package pro.sky.java.web.library.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.web.library.repository.BookRepository;
import pro.sky.java.web.library.service.BookService;

@RestController
@RequestMapping("books")
public class BookController {

    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    // http://localhost:8080/books/add?name=WarAndPeace4&authorFirstName=Lev&authorLastName=Tolstoy&publishingYear=1870
    @GetMapping("add")
    public String addBook(
            @RequestParam String name,
            @RequestParam String authorFirstName,
            @RequestParam String authorLastName,
            @RequestParam int publishingYear
    ) {
        if (service.addBook(name, authorFirstName, authorLastName, publishingYear)) {
            return "Book is added";
        } else {
            return "Book isn't added";
        }
    }

    // http://localhost:8080/books/remove?bookName=WarAndPeace2
    @GetMapping("remove")
    public String removeBook(@RequestParam String bookName) {
        if (service.removeBook(bookName)) {
            return "Book " + bookName + " is removed";
        } else {
            return "Book " + bookName + " isn't found";
        }
    }

    // http://localhost:8080/books/print
    @GetMapping("print")
    public String printBook() {
        return service.printBooks();
    }
}
