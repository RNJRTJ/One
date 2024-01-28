package squad25.comercioFacil.services;

public interface GenericCrudService {
	Object save(Object object);
	
	Object getById(Long id);
	
	Object update(Long id, Object updatedObject);
	
	void deleteById(Long id);
}