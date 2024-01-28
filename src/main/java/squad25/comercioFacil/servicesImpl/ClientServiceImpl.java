package squad25.comercioFacil.servicesImpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import squad25.comercioFacil.enums.SystemAlert;
import squad25.comercioFacil.models.Client;
import squad25.comercioFacil.repositories.ClientRepository;
import squad25.comercioFacil.services.ClientService;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private ClientRepository clientRepo;
	
	@Override
	public Object save(Object object) {	
		try {
			return this.clientRepo.save(mapper.map(object, Client.class));
			
		} catch (IllegalArgumentException e) {
			return null;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Object getById(Long id) {
		return this.clientRepo.findById(id).orElseThrow(() -> SystemAlert.printRuntimeEx(SystemAlert.NOT_FOUND_ERROR));
	}

	@Override
	public Object update(Long id, Object updatedObject) {
		Client existingClient = this.clientRepo.findById(id).orElse(null);
		Client updatedClient = mapper.map(updatedObject, Client.class);
		
		if(existingClient != null) {
			existingClient.setLogin(updatedClient.getLogin());
			existingClient.setPassword(updatedClient.getPassword());
			existingClient.setAccesLevel(updatedClient.getAccesLevel());
			existingClient.setUserName(updatedClient.getUserName());
			existingClient.setEmail(updatedClient.getEmail());			

			return this.clientRepo.save(existingClient);
		}else {
			return null;
		}
	}

	@Override
	public void deleteById(Long id) {
		this.clientRepo.deleteById(id);
	}

	@Override
	public Client getByEmailAndPassword(String email, String password) {
		return this.clientRepo.findByEmailAndPassword(email, password);
	}
}