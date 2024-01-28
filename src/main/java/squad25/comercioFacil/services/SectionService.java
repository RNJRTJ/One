package squad25.comercioFacil.services;

import squad25.comercioFacil.models.Section;

public interface SectionService {
	
	Section save(Section section);
	
	void logout(Long idSection);
	
}