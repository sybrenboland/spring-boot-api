package org.shboland.resource;

import org.shboland.db.hibernate.bean.Person;
import org.shboland.domain.JsonPerson;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/persons")
public interface IPersonController {

    @RequestMapping(path = "/{personId}", method = RequestMethod.GET)
    Person getPerson(@PathVariable String personId);

    @RequestMapping(value = "", method = RequestMethod.POST)
    ResponseEntity postPerson(@RequestBody JsonPerson person);

    @RequestMapping(value = "/{personId}", method = RequestMethod.PUT)
    ResponseEntity putPerson(@PathVariable("personId") String personId, @RequestBody JsonPerson jsonPerson);
}
