package org.shboland.resource;

import org.shboland.db.hibernate.bean.Person;
import org.shboland.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController implements IPersonController {

    @Autowired
    private PersonService personService;

    @Override
    public Person getPerson(@PathVariable String personId) {
        return personService.fetchPerson(personId);
    }
}

