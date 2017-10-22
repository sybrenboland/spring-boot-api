package org.shboland.resource;

import org.shboland.db.hibernate.bean.Person;
import org.shboland.domain.JsonPerson;
import org.shboland.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
public class PersonController implements IPersonController {

    @Autowired
    private PersonService personService;

    @Override
    public Person getPerson(@PathVariable String personId) {
        return personService.fetchPerson(personId);
    }

    @Override
    public ResponseEntity postPerson(@RequestBody JsonPerson jsonPerson) {
        Person person = personService.createPerson(jsonPerson);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(person.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @Override
    public ResponseEntity putPerson(@PathVariable String personId, @RequestBody JsonPerson jsonPerson) {

        Person currentPerson = personService.fetchPerson(personId);

        currentPerson = personService.updatePerson(currentPerson, jsonPerson);

        personService.save(currentPerson);

        return ResponseEntity.ok(currentPerson);
    }
}

