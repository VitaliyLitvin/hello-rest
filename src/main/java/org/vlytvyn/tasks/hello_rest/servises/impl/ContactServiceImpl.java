package org.vlytvyn.tasks.hello_rest.servises.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    private ContactRepository contactRepository;

    @Override
    public void writeRequest(JsonWriter writer, String filter) {
        Pattern p = Pattern.compile(filter);
        Pageable pageConf = new PageRequest(0, 100);
        Page<Contact> page;
        do {
            page = contactRepository.findAll(pageConf);
            for (Contact contact : page) {
                Matcher m = p.matcher(contact.getName());
                if (!m.matches()) {
                    writer.writeJson(contact);
                }
            }
            pageConf = page.nextPageable();
        } while (page.hasNext());
    }
}