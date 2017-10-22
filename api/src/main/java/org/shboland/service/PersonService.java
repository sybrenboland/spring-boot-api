package org.shboland.service;

import org.shboland.db.hibernate.bean.Person;
import org.shboland.db.repo.PersonRepository;
import org.shboland.domain.JsonPerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public Person fetchPerson(String personId) {
        return personRepository.findOne(Long.valueOf(personId));
    }

    public Person createPerson(JsonPerson jsonPerson) {
        return personRepository.save(new Person());
    }

    public void save(Person currentPerson) {
        personRepository.save(currentPerson);
    }

    public Person updatePerson(Person currentPerson, JsonPerson jsonPerson) {
        return currentPerson;
    }
}
