package squad25.comercioFacil.servicesImpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import squad25.comercioFacil.enums.SystemAlert;
import squad25.comercioFacil.models.Employer;
import squad25.comercioFacil.repositories.EmployerRepository;
import squad25.comercioFacil.services.EmployerService;

@Service
public class EmployerServiceImpl implements EmployerService {

	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private EmployerRepository employerRepo;
	
	@Override
	public Object save(Object object) {
		return this.employerRepo.save(mapper.map(object, Employer.class));
	}

	@Override
	public Object getById(Long id) {
		return this.employerRepo.findById(id).orElseThrow(() -> SystemAlert.printRuntimeEx(SystemAlert.NOT_FOUND_ERROR));
	}

	@Override
	public Object update(Long id, Object updatedObject) {
		Employer existingEmployer = this.employerRepo.findById(id).orElseThrow(() -> SystemAlert.printRuntimeEx(SystemAlert.NOT_FOUND_ERROR));
		Employer updatedEmployer = mapper.map(updatedObject, Employer.class);
		
		existingEmployer.setLogin(updatedEmployer.getLogin());
		existingEmployer.setPassword(updatedEmployer.getPassword());
		existingEmployer.setAccesLevel(updatedEmployer.getAccesLevel());
		existingEmployer.setUserName(updatedEmployer.getUserName());
		existingEmployer.setEmail(updatedEmployer.getEmail());
		existingEmployer.setTelephone(updatedEmployer.getTelephone());
		
		return this.employerRepo.save(existingEmployer);
	}

	@Override
	public void deleteById(Long id) {
		this.employerRepo.findById(id).orElseThrow(() -> SystemAlert.printRuntimeEx(SystemAlert.NOT_FOUND_ERROR));
		this.employerRepo.deleteById(id);	
	}

	@Override
	public Employer getByIdEnterprise(Long idEnterprise) {
		return this.employerRepo.findByIdEnterprise(idEnterprise);
	}
}