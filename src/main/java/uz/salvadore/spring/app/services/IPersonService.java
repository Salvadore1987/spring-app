package uz.salvadore.spring.app.services;

import uz.salvadore.spring.app.models.GridRequest;
import uz.salvadore.spring.app.models.GridResponse;
import uz.salvadore.spring.app.models.Person;

public interface IPersonService {

    GridResponse<Person> list(GridRequest gridRequest) throws Exception;
    Person one(Person person) throws Exception;

}
