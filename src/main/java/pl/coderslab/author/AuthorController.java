package pl.coderslab.author;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/author")
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorService authorService;

    @RequestMapping("/add")
    @ResponseBody
    public String hello() {
        Author author = new Author();
        author.setFirstName("Henryk");
        author.setLastName("Sienkiewicz");
        authorService.saveAuthor(author);
        return "Id dodanego autora to: " + author.getId();
    }

    @RequestMapping("/get/{author}")
    @ResponseBody
    public String getAuthor(@PathVariable Author author) {
//        Author author = authorService.findById(id);
        return author.toString();
    }

    @RequestMapping("/all")
    @ResponseBody
    public String getAllAuthors() {
        return authorService.getAllAutors().toString();
    }

    @RequestMapping("/update/{id}/{firstname}")
    @ResponseBody
    public String updateAuthor(@PathVariable long id, @PathVariable String firstname ) {
        Author author = authorService.findById(id);
        author.setFirstName(firstname);
        authorService.update(author);
        return author.toString();
    }

    @RequestMapping("/delete/{id}")
    @ResponseBody
    public String deleteAuthor(@PathVariable long id) {
        authorService.delete(id);
        return "deleted";
    }
}
