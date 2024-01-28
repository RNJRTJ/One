package squad25.comercioFacil.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import squad25.comercioFacil.enums.Category;
import squad25.comercioFacil.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
//	@Query
//	(nativeQuery = true, value = "SELECT p.* FROM `product` AS p "
//			+ "JOIN `enterprise` AS e ON p.fk_id_enterprise = e.id_enterprise "
//			+ "WHERE e.fk_id_market = :idMarket")
//	List<Product> findAllByIdMarket(@Param("idMarket") Long idMarket);
	
	@Query(nativeQuery = true, value = "SELECT p.* FROM `product` AS p "
		    + "JOIN `enterprise` AS e ON p.fk_id_enterprise = e.id_enterprise "
		    + "JOIN `marketplace` AS m ON e.fk_id_market = m.id_market "
		    + "WHERE m.id_market = :idMarket AND p.category = :category")
	public List<Product> findAllByIdMarketAndCategory(@Param("idMarket") Long idMarket, @Param("category") Category category);

	@Query(nativeQuery = true, value = "SELECT * FROM `product` WHERE fk_id_enterprise = :idEnterprise")
	public List<Product> findAllByIdEnterprise(@Param("idEnterprise") Long idEnterprise);
	
//	@Query(nativeQuery = true, value = "SELECT * FROM `product` WHERE fk_id_enterprise = :idEnterprise AND category IN (:categories)")
//	public List<Product> findAllByIdEnterpriseAndCategories(@Param("idEnterprise") Long idEnterprise, @Param("categories") List<Category> categories);
}
