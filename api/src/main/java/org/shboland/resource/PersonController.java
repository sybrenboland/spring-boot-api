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
import java.util.Optional;

@RestController
public class PersonController implements IPersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @Override
    public ResponseEntity<JsonPerson> getPerson(@PathVariable long personId) {
        Optional<JsonPerson> personOptional = personService.fetchPerson(personId);

        return personOptional.isPresent() ?
                ResponseEntity.ok(personOptional.get()) :
                ResponseEntity.notFound().build();
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
    public ResponseEntity<JsonPerson> putPerson(@PathVariable long personId, @RequestBody JsonPerson jsonPerson) {

        Optional<JsonPerson> personOptional = personService.fetchPerson(personId);

        if (!personOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        JsonPerson newPerson = personService.updatePerson(personId, jsonPerson);

        return ResponseEntity.ok(newPerson);
    }
}

