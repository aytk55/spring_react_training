package ilanaraba.com.repositories;

import ilanaraba.com.entitites.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact,Long> {
}
