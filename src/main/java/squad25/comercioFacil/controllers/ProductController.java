package squad25.comercioFacil.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import squad25.comercioFacil.services.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productSv;
	
	@GetMapping("/imagem/{idProduct}")
	@ResponseBody
	public byte[] exibirImagen(@PathVariable("idProduct") Long id) {
		return this.productSv.getById(id).getImage();
	}
}