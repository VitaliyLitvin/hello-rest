package org.vlytvyn.tasks.hello_rest.models;

import javax.persistence.*;

@Entity
@Table(name = "contacts")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;

    public Contact() {
    }

    public Contact(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

}
