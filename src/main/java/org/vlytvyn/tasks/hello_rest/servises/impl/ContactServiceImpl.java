package org.vlytvyn.tasks.hello_rest.servises.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vlytvyn.tasks.hello_rest.models.Contact;
import org.vlytvyn.tasks.hello_rest.repositories.ContactRepository;
import org.vlytvyn.tasks.hello_rest.servises.ContactService;
import org.vlytvyn.tasks.hello_rest.servises.JsonWriter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository repository;

    @Override
    public void writeRequest(JsonWriter writer, String filter){
        Pattern p = Pattern.compile(filter);
        for (Contact contact : repository.findAll()) {
            Matcher m = p.matcher(contact.getName());
            if (!m.matches()) {
                writer.writeJson(contact);
            }
        }

    }
}
