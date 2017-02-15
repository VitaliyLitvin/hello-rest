package org.vlytvyn.tasks.hello_rest.servises;

import org.vlytvyn.tasks.hello_rest.models.Contact;

/**
 * Created by 1 on 13.02.2017.
 */
public interface JsonWriter {
    void writeJson(Contact contact);
}
