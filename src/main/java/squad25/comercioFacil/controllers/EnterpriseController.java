package squad25.comercioFacil.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import squad25.comercioFacil.models.Contact;
import squad25.comercioFacil.models.Enterprise;
import squad25.comercioFacil.services.EnterpriseService;
import squad25.comercioFacil.services.ProductService;

@Controller
@RequestMapping("/enterprise")
public class EnterpriseController {

	@Autowired
	private ProductService produtoSv;
	
	@Autowired
	private EnterpriseService enterpriseSv;
	
	@GetMapping("/showByMap/{idEnterprise}")
	public String showPublicEnterprisePageByMap(Model model, @PathVariable("idEnterprise") Long idEnterprise) {
		model.addAttribute("enterprise", this.enterpriseSv.getById(idEnterprise));
		model.addAttribute("product", null);
		model.addAttribute("contact", new Contact());
		model.addAttribute("products", this.produtoSv.getAllByIdEnterprise(idEnterprise));
		
		return "/enterprise/publicEnterprisePage";
	}
	
	@GetMapping("/showByProduct/{idProduct}")
	public String showPublicEnterprisePageByProduct(Model model, @PathVariable("idProduct") Long idProduct) {
		Enterprise selectedEnterprise = this.enterpriseSv.getByIdProduct(idProduct);

		model.addAttribute("enterprise", selectedEnterprise);
		model.addAttribute("product", this.produtoSv.getById(idProduct));
		model.addAttribute("contact", new Contact());
		model.addAttribute("products", this.produtoSv.getAllByIdEnterprise(selectedEnterprise.getIdEnterprise()));
		
		return "/enterprise/publicEnterprisePage";
	}
	
	@GetMapping("/imagem/{idEnterprise}")
	@ResponseBody
	public byte[] exibirImagen(@PathVariable("idEnterprise") Long id) {
		Enterprise enterprise = (Enterprise) this.enterpriseSv.getById(id);

		return enterprise.getImage();
	}
}