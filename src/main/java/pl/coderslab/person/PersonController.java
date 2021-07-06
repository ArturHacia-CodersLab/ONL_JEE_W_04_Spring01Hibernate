package pl.coderslab.person;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.person.entity.Person;
import pl.coderslab.person.entity.PersonDetails;

@Controller
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonController {
    private final PersonService personService;

    @RequestMapping("/get/{id}")
    @ResponseBody
    public String getPerson(@PathVariable long id) {
        Person person = personService.findById(id);
        return person.toString();
    }

    @RequestMapping("/update/{id}/{login}")
    @ResponseBody
    public String updatePerson(@PathVariable long id, @PathVariable String login ) {
        Person person = personService.findById(id);
        person.setLogin(login);
        personService.update(person);
        return person.toString();
    }

    @RequestMapping("/delete/{id}")
    @ResponseBody
    public String deletePerson(@PathVariable long id) {
        personService.delete(id);
        return "deleted";
    }

    @GetMapping("/form")
    public String form(Model model) {
        model.addAttribute("person", new Person());
        return "/person/form";
    }

    @PostMapping("/form")
    @ResponseBody
    public String save(Person person) {
        person.setPersonDetails(new PersonDetails());
        personService.savePerson(person);
        return person.toString();
    }
}

