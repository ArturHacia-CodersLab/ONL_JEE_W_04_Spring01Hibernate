package pl.coderslab.publisher;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/publisher")
@RequiredArgsConstructor
public class PublisherController {
    private final PublisherService publisherService;

    @RequestMapping("/add")
    @ResponseBody
    public String hello() {
        Publisher publisher = new Publisher();
        publisher.setName("Helios");
        publisherService.savePublisher(publisher);
        return "Id dodanego wydawcy to: " + publisher.getId();
    }

    @RequestMapping("/get/{id}")
    @ResponseBody
    public String getPublisher(@PathVariable long id) {
        Publisher publisher = publisherService.findById(id);
        return publisher.toString();
    }

    @RequestMapping("/all")
    @ResponseBody
    public String getAllPublishers() {
        return publisherService.getAllPublishers().toString();
    }

    @RequestMapping("/update/{id}/{name}")
    @ResponseBody
    public String updatePublisher(@PathVariable long id, @PathVariable String name ) {
        Publisher publisher = publisherService.findById(id);
        publisher.setName(name);
        publisherService.update(publisher);
        return publisher.toString();
    }

    @RequestMapping("/delete/{id}")
    @ResponseBody
    public String deletePublisher(@PathVariable long id) {
        publisherService.delete(id);
        return "deleted";
    }
}
