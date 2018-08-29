package com.ph.caitlinanne.CaitlinAnne.controller;

import com.ph.caitlinanne.CaitlinAnne.service.ContactService;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.ph.caitlinanne.CaitlinAnne.model.Contact;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller
public class HomeController {

    @Autowired
    private ContactService contactService;

    @RequestMapping("/home")
    public String home(@ModelAttribute (value="contact") Contact contact, Model model) {
        return "home";
    }


    @PostMapping("contact/create")
    public String contactCreate(@ModelAttribute Contact contact, Model model) throws IOException {

        contact.setName(contact.getName());
        contact.setAge(contact.getAge());

        ObjectWriter ow = new ObjectMapper().writer();
        String json = ow.writeValueAsString(contact);
        System.out.println(json);
        contactService.createContact(contact);

        return "redirect:/home";
    }
}


