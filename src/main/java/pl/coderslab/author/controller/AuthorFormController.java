package pl.coderslab.author.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.author.Author;
import pl.coderslab.author.AuthorService;

@Controller
@RequestMapping("/form/author")
@RequiredArgsConstructor
public class AuthorFormController {
    private final AuthorService authorService;

    @GetMapping("/add")
    public String form(Model model) {
        Author author = new Author();
        model.addAttribute("author", author);
        return "/author/form";
    }

    @PostMapping("/add")
    public String save(Author author) {
        authorService.saveAuthor(author);
        return "redirect:/author/all";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable long id, Model model) {
        model.addAttribute("author", authorService.findById(id));
        return "/author/form";
    }

    @PostMapping("/edit/{id}")
    public String update(@PathVariable long id, Author author) {
        authorService.update(author);
        return "redirect:/author/all";
    }

    @GetMapping("/confirm/{id}")
    public String confirm(@PathVariable long id, Model model) {
        model.addAttribute("id", id);
        return "/author/confirm";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable long id) {
        authorService.delete(id);
        return "redirect:/author/all";
    }
}
