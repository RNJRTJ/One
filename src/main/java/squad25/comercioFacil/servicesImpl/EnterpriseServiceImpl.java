package squad25.comercioFacil.servicesImpl;

import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import squad25.comercioFacil.enums.SystemAlert;
import squad25.comercioFacil.models.Enterprise;
import squad25.comercioFacil.repositories.EmployerRepository;
import squad25.comercioFacil.repositories.EnterpriseRepository;
import squad25.comercioFacil.repositories.MarketPlaceRepository;
import squad25.comercioFacil.services.EnterpriseService;

@Service
public class EnterpriseServiceImpl implements EnterpriseService {

	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private EnterpriseRepository enterpriseRepo;
	
	@Autowired
	private EmployerRepository employerRepo;
	
	@Autowired
	private MarketPlaceRepository marketRepo;

	@Override
	public Object save(Object object) {
		return this.enterpriseRepo.save(mapper.map(object, Enterprise.class));
	}

	@Override
	public Object getById(Long id) {
		return this.enterpriseRepo.findById(id).orElseThrow(() -> SystemAlert.printRuntimeEx(SystemAlert.NOT_FOUND_ERROR));
	}
	
	@Override
	public Enterprise getByIdProduct(Long idProduct) {
		return this.enterpriseRepo.findByIdProduct(idProduct);
	}
	
	@Override
	public List<Enterprise> getAll() {
		return this.enterpriseRepo.findAll();
	}

	@Override
	public List<Enterprise> getAllByIdUser(Long idUser) {
		this.employerRepo.findById(idUser).orElseThrow(() -> SystemAlert.printRuntimeEx(SystemAlert.NOT_FOUND_ERROR));
		
		return this.enterpriseRepo.findAllByIdUser(idUser);
	}
	
	@Override
	public List<Enterprise> getAllByIdMarket(Long IdMarket) {
		this.marketRepo.findById(IdMarket).orElseThrow(() -> SystemAlert.printRuntimeEx(SystemAlert.NOT_FOUND_ERROR));
		
		return this.enterpriseRepo.findAllByIdMarket(IdMarket);
	}

	@Override //MultipartFile fileImage - fileImage.getBytes();
	public Object update(Long id, Object updatedObject) {
		Enterprise existingEnterprise = this.enterpriseRepo.findById(id).orElseThrow(() -> SystemAlert.printRuntimeEx(SystemAlert.NOT_FOUND_ERROR));
		Enterprise updatedEnterprise = mapper.map(updatedObject, Enterprise.class);
		
		existingEnterprise.setFantasyName(updatedEnterprise.getFantasyName());
		existingEnterprise.setCnpj(updatedEnterprise.getCnpj());
		existingEnterprise.setNumStore(updatedEnterprise.getNumStore());
		existingEnterprise.setDescription(updatedEnterprise.getDescription());
		existingEnterprise.setImage(updatedEnterprise.getImage());
		
		return this.enterpriseRepo.save(existingEnterprise);
	}
	
	@Override //MultipartFile fileImage - fileImage.getBytes();
	public Enterprise updateDescriptionImage(Long id, Enterprise updatedEnterprise) {
		Enterprise existingEnterprise = this.enterpriseRepo.findById(id).orElseThrow(() -> SystemAlert.printRuntimeEx(SystemAlert.NOT_FOUND_ERROR));
		
		existingEnterprise.setDescription(updatedEnterprise.getDescription());
		existingEnterprise.setImage(updatedEnterprise.getImage());
		
		return this.enterpriseRepo.save(existingEnterprise);
	}

	@Override
	public void deleteById(Long id) {
		this.enterpriseRepo.findById(id).orElseThrow(() -> SystemAlert.printRuntimeEx(SystemAlert.NOT_FOUND_ERROR));
		this.enterpriseRepo.deleteById(id);	
	}
}