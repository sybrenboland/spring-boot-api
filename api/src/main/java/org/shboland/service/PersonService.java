package org.shboland.service;

import org.shboland.convert.PersonConverter;
import org.shboland.db.hibernate.bean.Person;
import org.shboland.db.repo.PersonRepository;
import org.shboland.domain.JsonPerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonConverter personConverter;

    public Optional<JsonPerson> fetchPerson(long personId) {
        Person person = personRepository.findOne(personId);

        return person == null ? Optional.empty() : Optional.of(personConverter.toJson(person));
    }

    public JsonPerson createPerson(JsonPerson jsonPerson) {
        Person person = personRepository.save(new Person());

        return personConverter.toJson(person);
    }

    public JsonPerson updatePerson(long personId, JsonPerson jsonPerson) {
        Person currentPerson = personRepository.findOne(personId);

        Person newPerson = personRepository.save(currentPerson);

        return personConverter.toJson(newPerson);
    }
}
