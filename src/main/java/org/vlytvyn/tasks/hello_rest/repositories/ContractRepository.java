package org.vlytvyn.tasks.hello_rest.repositories;

import org.springframework.data.repository.CrudRepository;
import org.vlytvyn.tasks.hello_rest.models.Contact;

/**
 * Created by 1 on 12.02.2017.
 */
public interface ContractRepository extends CrudRepository<Contact, Long> {
}
