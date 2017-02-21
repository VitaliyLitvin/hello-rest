package org.vlytvyn.tasks.hello_rest.servises.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.vlytvyn.tasks.hello_rest.models.Contact;
import org.vlytvyn.tasks.hello_rest.repositories.ContactRepository;
import org.vlytvyn.tasks.hello_rest.servises.JsonWriter;

import java.util.ArrayList;
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
        when(repository.findAll(any(Pageable.class))).thenReturn(prepareTestData());
        contractService.writeRequest(jsonWriter, filterForNotEmptyResult);
        verify(jsonWriter, times(2)).writeJson(isA(Contact.class));
    }

    private Page<Contact> prepareTestData() {
        List<Contact> contacts = new ArrayList<>(3);
        contacts.add(new Contact(1, "TestContract1"));
        contacts.add(new Contact(2, "TestContract2"));
        contacts.add(new Contact(3, "TestContract3"));
        Page<Contact> result = new PageImpl(contacts);
        return result;
    }
}