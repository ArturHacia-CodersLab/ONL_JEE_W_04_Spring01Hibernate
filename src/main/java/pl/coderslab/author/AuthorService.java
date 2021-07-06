package pl.coderslab.author;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.book.Book;
import pl.coderslab.book.BookService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorDao authorDao;
    private final BookService bookService;

    public void saveAuthor(Author author) {
        authorDao.saveAuthor(author);
    }

    public Author findById(long id) {
        return authorDao.findById(id);
    }

    public List<Author> getAllAutors() {
        return authorDao.getAllAutors();
    }

    public void update(Author author) {
        authorDao.update(author);
    }

    public void delete(long id) {
        Author author = findById(id);
        List<Book> books = bookService.getBookWithAuthor(author);
        books.stream()
                        .forEach(b -> bookService.delete(b.getId()));
        authorDao.delete(author);
    }
}
