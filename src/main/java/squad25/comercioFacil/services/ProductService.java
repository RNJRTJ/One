package squad25.comercioFacil.services;

import java.util.List;

import squad25.comercioFacil.enums.Category;
import squad25.comercioFacil.models.Product;

public interface ProductService {
	Product save(Product product);
	
	Product getById(Long id);
	
//	List<Product> getAllByIdMarket(Long IdMarket);
	
	List<Product> getAllByIdMarketAndCategory(Long idMarket, Category category);
	
	List<Product> getAllByIdEnterprise(Long idEnterprise);
	
//	List<Product> getAllByIdEnterpriseAndCategories(Long idEnterprise, List<Category> categories);
	
	Product update(Long id, Product updatedProduct);
	
	void deleteById(Long id);
}