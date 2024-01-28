package squad25.comercioFacil.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import squad25.comercioFacil.models.Section;

@Repository
public interface SectionRepository extends JpaRepository<Section, Long>{
	
}