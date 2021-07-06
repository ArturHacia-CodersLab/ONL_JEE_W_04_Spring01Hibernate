package pl.coderslab.book.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.author.Author;
import pl.coderslab.author.AuthorService;
import pl.coderslab.book.Book;
import pl.coderslab.book.BookService;
import pl.coderslab.publisher.Publisher;
import pl.coderslab.publisher.PublisherService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/book")
public class BookController {
    private final BookService bookService;
    private final PublisherService publisherService;
    private final AuthorService authorService;

    @RequestMapping("/add")
    @ResponseBody
    public String hello() {
        Publisher publisher = new Publisher();
        publisher.setName("Helion");
        publisherService.savePublisher(publisher);

        Book book = new Book();
        book.setTitle("Thinking in Java");
        book.setRating(48);
        book.setDescription("On niej musisz zacząć");
        book.setPublisher(publisher);

        List<Author> authors = new ArrayList<>();
        authors.add(authorService.findById(1));
        authors.add(authorService.findById(2));
        book.setAuthors(authors);

        bookService.saveBook(book);
        return "Id dodanej książki to:" + book.getId();
    }

    @RequestMapping("/all")
    public String getAll(Model model) {
        model.addAttribute("books", bookService.getAll());
        return "/book/all";
    }

    @RequestMapping("/update/{id}/{title}")
    @ResponseBody
    public String updateBook(@PathVariable long id, @PathVariable String title ) {
        Book book = bookService.findById(id);
        book.setTitle(title);
        bookService.update(book);
        return book.toString();
    }

    @RequestMapping("/get/{id}")
    @ResponseBody
    public String getBook(@PathVariable long id) {
        Book book = bookService.findById(id);
        return book.toString();
    }

    @RequestMapping("/delete/{id}")
    @ResponseBody
    public String deleteBook(@PathVariable long id) {
        bookService.delete(id);
        return "deleted";
    }

    @RequestMapping("/rating/{rating}")
    @ResponseBody
    public String findAllByRating(@PathVariable int rating) {
        return bookService.findAllByRating(rating).toString();
    }

    @RequestMapping("/all/publisher")
    @ResponseBody
    public String getBookWithPublisher() {
        return bookService.getBookWithPublisher().toString();
    }

    @RequestMapping("/all/publisher/{id}")
    @ResponseBody
    public String getBookWithPublisher(@PathVariable int id) {
        Publisher publisher = publisherService.findById(id);
        if (publisher == null) {
            return "Nie ma takiego wydawcy";
        }
        return bookService.getBookWithPublisher(publisher).toString();
    }

    @RequestMapping("/all/author/{id}")
    @ResponseBody
    public String getBookWithAuthor(@PathVariable int id) {
        Author author = authorService.findById(id);
        if (author == null) {
            return "Nie ma takiego autora";
        }
        return bookService.getBookWithAuthor(author).toString();
    }
}
