package squad25.comercioFacil.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import squad25.comercioFacil.models.Enterprise;

@Repository
public interface EnterpriseRepository extends JpaRepository<Enterprise, Long>{
	
	@Query(nativeQuery = true, value = "SELECT e.* FROM enterprise AS e "
	        + "JOIN product AS p ON e.id_enterprise = p.fk_id_enterprise "
	        + "WHERE p.id_product = :idProduct")
	Enterprise findByIdProduct(@Param("idProduct") Long idProduct);
	
	@Query
	(nativeQuery = true, value = "SELECT * FROM `enterprise` WHERE fk_id_user = :idUser")
	List<Enterprise> findAllByIdUser(@Param("idUser") Long idUser);
	
	@Query
	(nativeQuery = true, value = "SELECT * FROM `enterprise` WHERE fk_id_market = :idMarket")
	List<Enterprise> findAllByIdMarket(@Param("idMarket") Long idMarket);
	
//	@Query
//	(nativeQuery = true, value = "SELECT * FROM `enterprise` WHERE num_store = :numStore AND id_market = :id_market")
//	Enterprise findBynumStore(String numStore, Long id_market);
}