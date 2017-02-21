package org.vlytvyn.tasks.hello_rest.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.vlytvyn.tasks.hello_rest.models.Contact;

public interface ContactRepository extends CrudRepository<Contact, Long> {
    Page<Contact> findAll(Pageable pageable);
}
