package org.vlytvyn.tasks.hello_rest.servises.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.vlytvyn.tasks.hello_rest.models.Contact;
import org.vlytvyn.tasks.hello_rest.repositories.ContactRepository;
import org.vlytvyn.tasks.hello_rest.servises.JsonWriter;

import java.util.LinkedList;
import java.util.List;

import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class ContractServiceImplTest {

    @InjectMocks
    ContactServiceImpl contractService;
    @Mock
    private ContactRepository repository;
    @Mock
    JsonWriter jsonWriter;

    @Test
    public void writeRequestTest() throws Exception {
        String filterForNotEmptyResult = "^.*[i1].*$";
        when(repository.findAll()).thenReturn(prepareTestData());
        contractService.writeRequest(jsonWriter, filterForNotEmptyResult);
        verify(jsonWriter, times(2)).writeJson(isA(Contact.class));
    }

    private List<Contact> prepareTestData() {
        List<Contact> result = new LinkedList();
        result.add(new Contact(1, "TestContract1"));
        result.add(new Contact(2, "TestContract2"));
        result.add(new Contact(3, "TestContract3"));
        return result;
    }
}