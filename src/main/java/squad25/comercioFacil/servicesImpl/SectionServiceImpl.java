package squad25.comercioFacil.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import squad25.comercioFacil.models.Section;
import squad25.comercioFacil.repositories.SectionRepository;
import squad25.comercioFacil.services.SectionService;

@Service
public class SectionServiceImpl implements SectionService {

	@Autowired
	private SectionRepository sectionRepo;
	
	@Override
	public Section save(Section section) {
		return this.sectionRepo.save(section);
	}

	@Override
	public void logout(Long idSection) {
		this.sectionRepo.deleteById(idSection);
	}
}