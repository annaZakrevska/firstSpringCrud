package a.zak.springcourse.controlers;

import a.zak.springcourse.dao.PersonDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String index(Model model) {
        model.addAttribute("people",personDAO.show());
        return "/people/show";
    }

    @GetMapping("/{id}")
    //Getting one person from DAO with its id
    public String show(@PathVariable ("id") int id, Model model) {
        model.addAttribute("person",personDAO.index(id));
        return "/people/index";
    }
}
