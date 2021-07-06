package pl.coderslab.publisher;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.book.Book;
import pl.coderslab.book.BookService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PublisherService {
    private final PublisherDao publisherDao;
    private final BookService bookService;

    public void savePublisher(Publisher publisher) {
        publisherDao.savePublisher(publisher);
    }

    public Publisher findById(long id) {
        return publisherDao.findById(id);
    }

    public List<Publisher> getAllPublishers() {
        return publisherDao.getAllPublishers();
    }

    public void update(Publisher publisher) {
        publisherDao.update(publisher);
    }

    public void delete(long id) {
        Publisher publisher = findById(id);
        List<Book> books = bookService.getBookWithPublisher(publisher);
        books.stream()
                        .forEach(b -> bookService.delete(b.getId()));
        publisherDao.delete(publisher);
    }
}
