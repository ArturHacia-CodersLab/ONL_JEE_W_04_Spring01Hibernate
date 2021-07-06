package pl.coderslab.publisher.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.book.BookService;
import pl.coderslab.publisher.Publisher;
import pl.coderslab.publisher.PublisherService;

@Controller
@RequestMapping("/form/publisher")
@RequiredArgsConstructor
public class PublisherFormController {
    private final PublisherService publisherService;

    @GetMapping("/add")
    public String form(Model model) {
        model.addAttribute("publisher", new Publisher());
        return "/publisher/form";
    }

    @PostMapping("/add")
    public String save(Publisher publisher) {
        publisherService.savePublisher(publisher);
        return "redirect:/publisher/all";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable long id, Model model) {
        model.addAttribute("publisher", publisherService.findById(id));
        return "/publisher/form";
    }

    @PostMapping("/edit/{id}")
    public String update(@PathVariable long id, Publisher publisher) {
        publisherService.update(publisher);
        return "redirect:/publisher/all";
    }

    @GetMapping("/confirm/{id}")
    public String confirm(@PathVariable long id, Model model) {
        model.addAttribute("id", id);
        return "/publisher/confirm";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable long id) {
        publisherService.delete(id);
        return "redirect:/publisher/all";
    }
}
