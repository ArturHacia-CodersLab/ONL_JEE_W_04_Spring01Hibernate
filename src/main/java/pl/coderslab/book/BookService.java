package pl.coderslab.book;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.author.Author;
import pl.coderslab.publisher.Publisher;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookDao bookDao;

    public void saveBook(Book book) {
        bookDao.saveBook(book);
    }

    public Book findById(long id) {
        return bookDao.findById(id);
    }

    public List<Book> getAll() {
        return bookDao.getAll();
    }

    public void update(Book book) {
        bookDao.update(book);
    }

    public void delete(Long id) {
        bookDao.delete(id);
    }

    public List<Book> findAllByRating(int rating) {
        return bookDao.findAllByRating(rating);
    }

    public List<Book> getBookWithPublisher() {
        return bookDao.getBookWithPublisher();
    }

    public List<Book> getBookWithPublisher(Publisher publisher) {
        return bookDao.getBookWithPublisher(publisher);
    }

    public List<Book> getBookWithAuthor(Author author) {
        return bookDao.getBookWithAuthor(author);
    }

    public void changeValuesForEdit(Book in, Book base) {
        base.setTitle(in.getTitle());
        base.setRating(in.getRating());
        base.setDescription(in.getDescription());
    }
}
