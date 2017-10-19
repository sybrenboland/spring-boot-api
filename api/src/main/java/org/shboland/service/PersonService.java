package org.shboland.service;

import org.shboland.db.hibernate.bean.Person;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    public Person fetchPerson(String personId) {
        Person person = new Person();
        person.setId(new Long(personId));
        return person;
    }
}
