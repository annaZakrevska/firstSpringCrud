package a.zak.springcourse.controlers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/people")
public class PeopleControler {

    @GetMapping()
    //Getting all people from DAO
    public String index(Model model) {
        return null;
    }

    @GetMapping("/{id}")
    //Getting one person from DAO with its id
    public String show(@PathVariable ("id") int id, Model model) {

        return null;
    }
}
