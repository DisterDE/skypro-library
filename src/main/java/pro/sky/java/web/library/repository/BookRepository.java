package pro.sky.java.web.library.repository;

import org.springframework.stereotype.Repository;
import pro.sky.java.web.library.domain.Book;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepository {
    private final List<Book> books = new ArrayList<>();

    public boolean addBook(Book book) {
        return books.add(book);
    }

    public boolean removeBook(String bookName) {
        return books.removeIf(b -> bookName.equals(b.getName()));
    }

    public String printAllBooks() {
        StringBuilder sb = new StringBuilder();
        sb.append("Books:\n");
        for (Book book : books) {
            sb.append(book);
            sb.append("\n");
        }
        return sb.toString();
    }
}
