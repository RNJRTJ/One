package squad25.comercioFacil.servicesImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import squad25.comercioFacil.enums.SystemAlert;
import squad25.comercioFacil.models.Contact;
import squad25.comercioFacil.repositories.ContactRepository;
import squad25.comercioFacil.services.ContactService;

@Service
public class ContactServiceImpl implements ContactService {
	
	@Autowired
	private ContactRepository contactRepo;

	@Override
	public Contact save(Contact contact) {
		Contact savedContact = this.contactRepo.save(contact);
		SystemAlert.printSuccess(SystemAlert.SUCCESSFUL_OPERATION);
		
		return savedContact;
	}

	@Override
	public Contact getById(Long id) {
		return this.contactRepo.findById(id).orElseThrow(() -> SystemAlert.printRuntimeEx(SystemAlert.NOT_FOUND_ERROR));
	}

	@Override
	public List<Contact> getAllByEmailRecipient(String emailRecipient) {
		return this.contactRepo.findAllByEmailRecipient(emailRecipient);
	}

	@Override
	public void deleteById(Long id) {
		this.contactRepo.findById(id).orElseThrow(() -> SystemAlert.printRuntimeEx(SystemAlert.NOT_FOUND_ERROR));
		this.contactRepo.deleteById(id);	
	}
}