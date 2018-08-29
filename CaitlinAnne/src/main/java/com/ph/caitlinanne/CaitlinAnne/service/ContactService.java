package com.ph.caitlinanne.CaitlinAnne.service;

import com.ph.caitlinanne.CaitlinAnne.Constants;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import com.ph.caitlinanne.CaitlinAnne.model.Contact;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Service
public class ContactService {
    public Contact createContact (Contact contact) throws IOException {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Content-Type", "application/json");
        HttpEntity httpEntity = new HttpEntity(contact, httpHeaders);


        return new RestTemplate().postForObject("http://localhost:8080"+Constants.ENDPOINT_CONTACTS_CREATE,httpEntity,Contact.class);
    }
}
