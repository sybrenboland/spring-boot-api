package org.shboland.repo;

import org.shboland.db.hibernate.bean.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Long> {
}
