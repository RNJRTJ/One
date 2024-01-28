package squad25.comercioFacil.services;

import java.util.List;

import squad25.comercioFacil.models.Enterprise;

public interface EnterpriseService extends GenericCrudService {

	Enterprise getByIdProduct(Long idProduct);
	
	List<Enterprise> getAll();
		
	List<Enterprise> getAllByIdUser(Long idUser);
	
	List<Enterprise> getAllByIdMarket(Long IdMarket);
	
	Enterprise updateDescriptionImage(Long id, Enterprise updatedEnterprise);
}