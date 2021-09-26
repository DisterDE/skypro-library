package pro.sky.java.web.library.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.web.library.entity.Author;
import pro.sky.java.web.library.service.AuthorService;

import java.util.Set;

@RestController
@RequestMapping("author")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    // http://localhost:8080/library/author/add?firstName=Sergey&lastName=Esenin
    @GetMapping("add")
    public Author add(@RequestParam String firstName, @RequestParam String lastName) {
        return authorService.add(firstName, lastName);
    }

    // http://localhost:8080/library/author/all
    @GetMapping("all")
    public Iterable<Author> findAll() {
        return authorService.findAll();
    }

    // http://localhost:8080/library/author/find?lastName=King
    // http://localhost:8080/library/author/find?firstName=Stephen&lastName=King
    @GetMapping("find")
    public Iterable<Author> find(
            @RequestParam(required = false) String firstName,
            @RequestParam String lastName
    ) {
        if (firstName == null) {
            return authorService.findByLastName(lastName);
        }
        return Set.of(authorService.findByFirstNameAndLastName(firstName, lastName));
    }
}
