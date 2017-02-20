package org.vlytvyn.tasks.hello_rest.controllers;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.vlytvyn.tasks.hello_rest.models.Contact;
import org.vlytvyn.tasks.hello_rest.servises.ContactService;
import org.vlytvyn.tasks.hello_rest.servises.JsonWriter;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.regex.PatternSyntaxException;

@RestController
@RequestMapping("/hello")
public class ContactController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ContactService contractService;

    @RequestMapping(value = "contacts",
            method = RequestMethod.GET)
    public void getContracts(@RequestParam("nameFilter") String nameFilter,
                             HttpServletResponse response) throws IOException {
        if (nameFilter.isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Filter must be populated");
            logger.info("Request was received without filter");
        } else {
            try {
                logger.info("Request was received with filter " + nameFilter);
                response.getWriter();
                contractService.writeRequest(new JsonWriterImpl(response.getWriter()), nameFilter);
                logger.info("Response has been sent successfully");
            } catch (PatternSyntaxException e){
                logger.error(nameFilter +" is incorrect", e);
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, nameFilter +" is incorrect");
            }
            catch (Exception e) {
                logger.error("Unexpected error", e);
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR,"Unexpected error");
            }
        }
    }

    private class JsonWriterImpl implements JsonWriter {
        Writer writer;

        public JsonWriterImpl(Writer writer) {
            this.writer = writer;
        }

        @Override
        public void writeJson(Contact contact) {
            JSONObject JSONObject = new JSONObject();
            try {
                JSONObject.put("id", contact.getId());
                JSONObject.put("name", contact.getName());
                JSONObject.write(writer);
            } catch (JSONException e) {
                logger.error("Exception during the JSON writing to the response ", e);
            }
        }
    }
}
