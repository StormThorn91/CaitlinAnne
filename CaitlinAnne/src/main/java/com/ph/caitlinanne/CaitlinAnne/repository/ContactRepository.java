package com.ph.caitlinanne.CaitlinAnne.repository;

import com.ph.caitlinanne.CaitlinAnne.model.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Integer> {

}
