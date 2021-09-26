package pro.sky.java.web.library.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Objects;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Length(min = 2, message = "Too short book name")
    private String name;

    @Min(value = 1500, message = "Year is earlier than 1500")
    @Max(value = 2021, message = "Year is later than current year")
    private int publishingYear;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;

    // Hibernate required
    public Book() {
    }

    public Book(String name, int publishingYear, Author author) {
        this.name = name;
        this.publishingYear = publishingYear;
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPublishingYear() {
        return publishingYear;
    }

    public void setPublishingYear(int publishingYear) {
        this.publishingYear = publishingYear;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id.equals(book.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", publishingYear=" + publishingYear +
                ", author=" + author +
                '}';
    }
}
