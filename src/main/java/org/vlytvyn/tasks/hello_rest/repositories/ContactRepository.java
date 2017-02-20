package org.vlytvyn.tasks.hello_rest.repositories;

import org.springframework.data.repository.CrudRepository;
import org.vlytvyn.tasks.hello_rest.models.Contact;

public interface ContactRepository extends CrudRepository<Contact, Long> {
}
