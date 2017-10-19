package org.shboland.resource;

import org.shboland.db.hibernate.bean.Person;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/persons")
public interface IPersonController {

    @RequestMapping(path = "/{personId}", method = RequestMethod.GET)
    Person getPerson(@PathVariable String personId);
}
