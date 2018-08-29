package com.ph.caitlinanne.CaitlinAnne.controller;


import com.ph.caitlinanne.CaitlinAnne.model.Contact;
import com.ph.caitlinanne.CaitlinAnne.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/contact")
public class ContactController {
    @Autowired
    private ContactRepository contactRepository;

    @RequestMapping(value="/add", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public ResponseEntity create(@RequestBody Contact contact){
        contact.setName(contact.getName());
        contact.setBirthDate(contact.getBirthDate());
        contact.setAge(contact.getAge());
        contactRepository.save(contact);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/all")
    public @ResponseBody Iterable<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    @GetMapping("/{id}")
    public Contact getContactById (@PathVariable int id) {
        Optional<Contact> getContact = contactRepository.findById(id);
        return getContact.get();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteContactById(@PathVariable int id) {
        contactRepository.deleteById(id);
    }

    @PutMapping(value= "update/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Contact> updateContactById (@RequestBody Contact contact, @PathVariable int id) {
        Optional<Contact> updateById = contactRepository.findById(id);

        contact.setId(id);

        contactRepository.save(contact);

        return ResponseEntity.noContent().build();
    }
}


