package pl.coderslab.book.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.author.Author;
import pl.coderslab.author.AuthorService;
import pl.coderslab.book.Book;
import pl.coderslab.book.BookService;
import pl.coderslab.publisher.Publisher;
import pl.coderslab.publisher.PublisherService;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/form/book")
@RequiredArgsConstructor
public class BookFormController {
    private final BookService bookService;
    private final PublisherService publisherService;
    private final AuthorService authorService;

    @ModelAttribute("publishers")
    public List<Publisher> getPublishers() {
        return publisherService.getAllPublishers();
    }

    @ModelAttribute("authorList")
    public List<Author> getAuthors() {
        return authorService.getAllAutors();
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("book", new Book());
        return "/book/form";
    }

    @PostMapping("/add")
    public String add(Book book) {
        bookService.saveBook(book);
        return "redirect:/book/all";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable long id, Model model) {
        model.addAttribute("book", bookService.findById(id));
        return "/book/form";
    }

    @PostMapping("/edit/{id}")
    public String update(@PathVariable long id, Book book) {
        bookService.update(book);
        return "redirect:/book/all";
    }

    @GetMapping("/confirm/{id}")
    public String confirm(@PathVariable long id, Model model) {
        model.addAttribute("id", id);
        return "/book/confirm";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable long id) {
        bookService.delete(id);
        return "redirect:/book/all";
    }
}
