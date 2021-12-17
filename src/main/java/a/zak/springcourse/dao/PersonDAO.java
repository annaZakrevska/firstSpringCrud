package a.zak.springcourse.dao;

import a.zak.springcourse.models.Person;
import org.postgresql.Driver;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;

    private static final String URL = "jdbc:postgresql://localhost:5432/firstSpring_db";
    private static final String user = "postgres";
    private static final String password = "Fyz1jkz2";

    private static Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(URL, user, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<Person> show() {
        List<Person> people = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM person";
            ResultSet resultSet = statement.executeQuery(SQL);

            while (resultSet.next()) {
                Person person = new Person();

                person.setId(resultSet.getInt("id"));
                person.setName(resultSet.getString("name"));
                person.setEmail(resultSet.getString("email"));
                person.setAge(resultSet.getInt("age"));

                people.add(person);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return people;
    }

    /*public Person index(int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }
*/
    public void save(Person person) {
        //person.setId(++PEOPLE_COUNT);
        //people.add(person);
        try {
            Statement statement = connection.createStatement();
            String SQL = "INSERT INTO Person VALUES(" + 1 + ",'" + person.getName() +
                    "'," + person.getAge() + ",'" + person.getEmail() + "')";

            statement.executeUpdate(SQL);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

  /*  public void update(int id, Person updatedPerson) {
        Person personToBeUpdated = index(id);

        personToBeUpdated.setName(updatedPerson.getName());
        personToBeUpdated.setAge(updatedPerson.getAge());
        personToBeUpdated.setEmail(updatedPerson.getEmail());
    }*/

    /*public void delete(int id) {
        people.removeIf(p -> p.getId() == id);
    }*/
}
