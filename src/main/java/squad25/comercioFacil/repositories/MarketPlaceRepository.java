package squad25.comercioFacil.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import squad25.comercioFacil.enums.State;
import squad25.comercioFacil.models.MarketPlace;

@Repository
public interface MarketPlaceRepository extends JpaRepository<MarketPlace, Long> {
	 @Query
	 (nativeQuery = true, value = "SELECT * FROM `marketplace` as m "
	 		+ "JOIN `address` as a ON m.fk_id_address = a.id_address "
	 		+ "WHERE a.state = :state")
	 List<MarketPlace> findByState(@Param("state") State state); 
}