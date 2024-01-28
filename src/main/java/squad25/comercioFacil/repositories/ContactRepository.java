package squad25.comercioFacil.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import squad25.comercioFacil.models.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long>{
	
	@Query(nativeQuery= true, value= "SELECT * FROM `contact` WHERE email_recipient LIKE :emailRecipient")
	List<Contact> findAllByEmailRecipient(@Param("emailRecipient") String emailRecipient);
}