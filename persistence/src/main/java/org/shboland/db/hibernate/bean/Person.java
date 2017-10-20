package org.shboland.db.hibernate.bean;

import javax.persistence.*;

@Entity
@Table(name = "PERSON")
public class Person {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "serial")
    private Long id;

    public Long getId() {
        return id;
    }
}
