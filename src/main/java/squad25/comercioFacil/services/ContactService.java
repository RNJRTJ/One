package squad25.comercioFacil.services;

import java.util.List;

import squad25.comercioFacil.models.Contact;

public interface ContactService {
	Contact save(Contact contact);
	
	Contact getById(Long id);
	
	List<Contact> getAllByEmailRecipient(String emailRecipient);
	
	void deleteById(Long id);
}