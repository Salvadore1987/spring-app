package uz.salvadore.spring.app.repositories.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import uz.salvadore.spring.app.mappers.PersonMapper;
import uz.salvadore.spring.app.models.GridRequest;
import uz.salvadore.spring.app.models.Person;
import uz.salvadore.spring.app.repositories.IPersonRepository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class PersonRepository implements IPersonRepository {

    private JdbcTemplate jdbcTemplate;

    private static final String SQL_LIST_QUERY = "select id, name, surname, age from people limit ? offset ?";
    private static final String SQL_ONE_QUERY = "select id, name, surname, age from people where id = ?";

    @Autowired
    public void setJdbcTemplate(@Qualifier("dataSource") DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Person> list(GridRequest gridRequest) throws Exception {
        return jdbcTemplate
                .query(SQL_LIST_QUERY, new PersonMapper(), gridRequest.getTake(), gridRequest.getSkip());
    }

    @Override
    public Person one(Long id) throws Exception {
        return jdbcTemplate
                .queryForObject(SQL_ONE_QUERY, new PersonMapper(), id);
    }
}
