package a.zak.springcourse.dao;

import a.zak.springcourse.models.Person;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int id_count;
    private List<Person> people;


    {
        people = new ArrayList<>();

        people.add(new Person(++id_count, "Tom"));
        people.add(new Person(++id_count, "Bob"));
        people.add(new Person(++id_count, "Mike"));
        people.add(new Person(++id_count, "Katy"));
    }

    public List<Person> show(){
        return people;
    }

    public Person index(int id){
        return people.stream().filter(person->person.getId()==id).findAny().orElse(null);
    }
}
