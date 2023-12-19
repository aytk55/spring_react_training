package ilanaraba.com.controllers;

import ilanaraba.com.entitites.Contact;
import ilanaraba.com.services.ContactService;
import ilanaraba.com.services.EmailService;
import ilanaraba.com.services.IlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class ContactController {
    @Autowired
    private ContactService contactService;


    @PostMapping("/contact")
    public void AddContact(@RequestBody Contact contact){
        contactService.saveMessage(contact);
    }
}
