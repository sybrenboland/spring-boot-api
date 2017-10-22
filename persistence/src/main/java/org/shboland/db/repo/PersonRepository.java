package org.shboland.db.repo;

import org.shboland.db.hibernate.bean.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
