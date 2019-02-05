package uz.salvadore.spring.app.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import uz.salvadore.spring.app.models.GridRequest;
import uz.salvadore.spring.app.models.GridResponse;
import uz.salvadore.spring.app.models.Person;
import uz.salvadore.spring.app.models.Response;
import uz.salvadore.spring.app.services.IPersonService;

@RestController
@RequestMapping(value = "/api/person")
public class PersonController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private IPersonService service;

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public ResponseEntity<Response<GridResponse<Person>>> list(@RequestBody GridRequest gridRequest) {
        Response<GridResponse<Person>> response = new Response<>();
        try {
            GridResponse<Person> gridResponse = service.list(gridRequest);
            response.setCode(0);
            response.setMessage("OK");
            response.setObject(gridResponse);
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            response.setCode(9999);
            response.setMessage(ex.getMessage());
        }
        return ResponseEntity.ok(response);
    }

    @RequestMapping(value = "one", method = RequestMethod.POST)
    public ResponseEntity<Response<Person>> one(@RequestBody Person person) {
        Response<Person> response = new Response<>();
        try {
            Person p = service.one(person);
            response.setCode(0);
            response.setMessage("OK");
            response.setObject(p);
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            response.setCode(9999);
            response.setMessage(ex.getMessage());
        }
        return ResponseEntity.ok(response);
    }

}
