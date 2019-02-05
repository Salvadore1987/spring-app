package uz.salvadore.spring.app.mappers;

import org.springframework.jdbc.core.RowMapper;
import uz.salvadore.spring.app.models.Person;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonMapper implements RowMapper<Person> {

    @Override
    public Person mapRow(ResultSet resultSet, int i) throws SQLException {
        Person person = new Person();
        person.setId(resultSet.getLong("ID"));
        person.setName(resultSet.getString("NAME"));
        person.setSurname(resultSet.getString("SURNAME"));
        person.setAge(resultSet.getInt("AGE"));
        return person;
    }
}
