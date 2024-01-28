package squad25.comercioFacil.services;

import squad25.comercioFacil.models.Employer;

public interface EmployerService extends GenericCrudService {
	
	Employer getByIdEnterprise(Long idEnterprise);
	
}