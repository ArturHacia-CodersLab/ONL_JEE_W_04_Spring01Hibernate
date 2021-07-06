package pl.coderslab.author;

import lombok.Data;
import pl.coderslab.book.Book;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = Author.TABLE_NAME)
@Data
public class Author {
    public static final String TABLE_NAME = "authors";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String firstName;
    private String lastName;

    public String getFullName() {
        return firstName + " " + lastName;
    }
}