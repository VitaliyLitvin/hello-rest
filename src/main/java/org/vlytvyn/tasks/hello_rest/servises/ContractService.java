package org.vlytvyn.tasks.hello_rest.servises;

/**
 * Created by 1 on 13.02.2017.
 */
public interface ContractService {
    void writeRequest(JsonWriter writer, String filter);
}
