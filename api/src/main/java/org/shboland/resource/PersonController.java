package org.shboland.resource;

import org.shboland.db.hibernate.bean.Person;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController implements IPersonController {

    @Override
    public Person getPerson(@PathVariable String personId) {
        Person person = new Person();
        person.setId(new Long(personId));
        return person;
    }
}

