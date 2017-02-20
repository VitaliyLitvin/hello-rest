package org.vlytvyn.tasks.hello_rest.servises;

public interface ContactService {
    void writeRequest(JsonWriter writer, String filter);
}
