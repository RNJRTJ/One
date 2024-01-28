package squad25.comercioFacil.servicesImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import squad25.comercioFacil.enums.Category;
import squad25.comercioFacil.enums.SystemAlert;
import squad25.comercioFacil.models.Product;
import squad25.comercioFacil.repositories.ProductRepository;
import squad25.comercioFacil.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepo;
	
	@Override
	public Product save(Product product) {
		return this.productRepo.save(product);
	}

	@Override
	public Product getById(Long id) {
		return this.productRepo.findById(id).orElseThrow(() -> SystemAlert.printRuntimeEx(SystemAlert.NOT_FOUND_ERROR));
	}

	@Override
	public List<Product> getAllByIdMarketAndCategory(Long idMarket, Category category) {
		return this.productRepo.findAllByIdMarketAndCategory(idMarket, category);
	}

	@Override
	public List<Product> getAllByIdEnterprise(Long idEnterprise) {
		return this.productRepo.findAllByIdEnterprise(idEnterprise);
	}

//	@Override
//	public List<Product> getAllByIdEnterpriseAndCategories(Long idEnterprise, List<Category> categories) {
//		return this.productRepo.findAllByIdEnterpriseAndCategories(idEnterprise, categories);
//	}

	@Override
	public Product update(Long id, Product updatedProduct) {
		Product existingProduct = this.productRepo.findById(id).orElseThrow(() -> SystemAlert.printRuntimeEx(SystemAlert.NOT_FOUND_ERROR));
		
		existingProduct.setName(updatedProduct.getName());
		existingProduct.setValue(updatedProduct.getValue());
		existingProduct.setImage(updatedProduct.getImage());
		existingProduct.setInStock(updatedProduct.isInStock());
		existingProduct.setCategory(updatedProduct.getCategory());
		
		return this.productRepo.save(existingProduct);
	}

	@Override
	public void deleteById(Long id) {
		this.productRepo.findById(id).orElseThrow(() -> SystemAlert.printRuntimeEx(SystemAlert.NOT_FOUND_ERROR));
		this.productRepo.deleteById(id);
	}
}