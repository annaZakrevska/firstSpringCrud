package a.zak.springcourse.controlers;

import a.zak.springcourse.dao.PersonDAO;
import a.zak.springcourse.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/people")
public class PeopleControler {

    private final PersonDAO personDAO;

    @Autowired
    public PeopleControler(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @GetMapping()
    //Getting all people from DAO
    public String show(Model model) {
        model.addAttribute("people", personDAO.show());
        return "/people/show";
    }

    /*@GetMapping("/{id}")
    //Getting one person from DAO with its id
    public String index(@PathVariable("id") int id, Model model) {
        model.addAttribute("person", personDAO.index(id));
        return "/people/index";
    }*/

    @GetMapping("/new")
    public String newPerson(@ModelAttribute("person") Person person) {
        return "people/new";
    }

    @PostMapping
    public String create(@ModelAttribute("person") @Valid Person person, BindingResult biningResult) {

        if (biningResult.hasErrors())
            return "people/new";

        personDAO.save(person);
        return "redirect:/people";
    }

   /* @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("person", personDAO.index(id));
        return "people/edit";
    }*/

   /* @PatchMapping("/{id}")
    public String update(@ModelAttribute("person")@Valid Person person,BindingResult bindingRes, @PathVariable("id") int id) {
       if(bindingRes.hasErrors())
           return "people/edit";

        personDAO.update(id, person);
        return "redirect:/people";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        personDAO.delete(id);
        return "redirect:/people";
    }*/

}
