package uz.salvadore.spring.app.repositories;

import uz.salvadore.spring.app.models.GridRequest;
import uz.salvadore.spring.app.models.Person;

import java.util.List;

public interface IPersonRepository {
    List<Person> list(GridRequest gridRequest) throws Exception;
    Person one(Long id) throws Exception;
}
