package org.shboland.resource;

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
    public JsonPerson getPerson(@PathVariable long personId) {
        return personService.fetchPerson(personId);
    }

    @Override
    public ResponseEntity postPerson(@RequestBody JsonPerson jsonPerson) {
        JsonPerson newPerson = personService.createPerson(jsonPerson);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(newPerson.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @Override
    public ResponseEntity putPerson(@PathVariable long personId, @RequestBody JsonPerson jsonPerson) {

        JsonPerson currentPerson = personService.fetchPerson(personId);

        JsonPerson newPerson = personService.updatePerson(personId, jsonPerson);

        return ResponseEntity.ok(newPerson);
    }
}

