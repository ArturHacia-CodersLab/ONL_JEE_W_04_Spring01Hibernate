package pl.coderslab.publisher;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PublisherService {
    private final PublisherDao publisherDao;

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
        publisherDao.delete(id);
    }
}
