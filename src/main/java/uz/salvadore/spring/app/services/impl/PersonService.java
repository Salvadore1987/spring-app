package uz.salvadore.spring.app.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.salvadore.spring.app.models.GridRequest;
import uz.salvadore.spring.app.models.GridResponse;
import uz.salvadore.spring.app.models.Person;
import uz.salvadore.spring.app.repositories.IPersonRepository;
import uz.salvadore.spring.app.services.IPersonService;

import java.util.List;

@Service
public class PersonService implements IPersonService {

    private IPersonRepository repository;

    @Autowired
    public void setRepository(IPersonRepository repository) {
        this.repository = repository;
    }

    @Override
    public GridResponse<Person> list(GridRequest gridRequest) throws Exception {
        List<Person> people = repository.list(gridRequest);
        GridResponse gridResponse = new GridResponse<>();
        gridResponse.setItems(people);
        gridResponse.setTotalItemsCount(people.size());
        return gridResponse;
    }

    @Override
    public Person one(Person person) throws Exception {
        return repository.one(person.getId());
    }
}
