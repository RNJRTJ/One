package squad25.comercioFacil.services;

import squad25.comercioFacil.models.Client;
import squad25.comercioFacil.models.User;

public interface ClientService extends GenericCrudService {
	
	Client getByEmailAndPassword(String email, String password);
	
}