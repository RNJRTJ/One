package squad25.comercioFacil.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import squad25.comercioFacil.enums.AccesLevel;
import squad25.comercioFacil.models.Employer;

@Repository
public interface EmployerRepository extends JpaRepository<Employer, Long> {
	 
	@Query
	 (value = "SELECT * FROM user WHERE acces_level='EMPLOYER'",nativeQuery = true)
     List<Employer> findByAccesLevel(AccesLevel accesLevel);
	 
	 @Query
	 (nativeQuery = true, value = "SELECT u.* FROM user AS u "
	 		+ "INNER JOIN enterprise AS en ON u.id_user = en.fk_id_user "
	 		+ "WHERE en.id_enterprise = :idEnterprise")
     Employer findByIdEnterprise(@Param("idEnterprise") Long idEnterprise);
}