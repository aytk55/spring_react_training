package ilanaraba.com.services;

import ilanaraba.com.entitites.Contact;
import ilanaraba.com.repositories.ContactRepository;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Service;

@Service
public class ContactService {

    private ContactRepository contactRepository;
    private EmailService emailService;
    public ContactService (ContactRepository contactRepository,EmailService emailService){
        this.contactRepository=contactRepository;
        this.emailService=emailService;
    }
    public void saveMessage(Contact contact){
        contactRepository.save(contact);
        String email=contact.getEmail();

        try {
            emailService.sendEmail(email, "Mesajınız alınmıştır", "En kısa sürede geri dönüş yapılacaktır");
            System.out.println("E-posta gönderme işlemi başarılı.");
        } catch (MailException e) {
            System.err.println("E-posta gönderme işlemi sırasında bir hata oluştu:");
            e.printStackTrace();
        }
    }
}
