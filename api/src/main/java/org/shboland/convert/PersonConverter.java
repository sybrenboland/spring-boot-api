package org.shboland.convert;

import org.shboland.db.hibernate.bean.Person;
import org.shboland.domain.JsonPerson;
import org.springframework.stereotype.Service;

@Service
public class PersonConverter {

    public JsonPerson toJson(Person person) {
        JsonPerson jsonPerson = new JsonPerson();

        jsonPerson.setId(person.getId());

        return jsonPerson;
    }
}
