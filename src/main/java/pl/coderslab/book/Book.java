package pl.coderslab.book;


import lombok.Data;
import pl.coderslab.author.Author;
import pl.coderslab.publisher.Publisher;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = Book.TABLE_NAME)
@Data
public class Book {
    public static final String TABLE_NAME = "books";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String title;
    private int rating;
    private String description;

    @ManyToOne
    private Publisher publisher;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "author_id"))
    private List<Author> authors;
}
