package squad25.comercioFacil.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import squad25.comercioFacil.services.EnterpriseService;

@Controller
@RequestMapping("/employer")
public class EmployerController {
	
	@Autowired
	private EnterpriseService enterpriseSv;
	
	@GetMapping("/id={id}/getAllEnterprises")
	public String getAllEnterprisesByIdUser(Model model, @PathVariable("id") Long id) {
		model.addAttribute("enterprises", this.enterpriseSv.getAllByIdUser(id));
		
		return "/employer/enterprisesPage";
	}
	
	@GetMapping("/getAllNotifications")
	public String getAllContactsByEmailRecipient() {
		return "/employer/notificationsPage";
	}
	
	@GetMapping("/EnableEnterprise")
	public String showFormEnablePreEnterprise() {
		return "/employer/formEnablePreEnterprise";
	}
	
//	@PostMapping("/atualizarPreRegistro")
//	public ModelAndView atualizarRegistroEnterprise(@ModelAttribute("enterprise") Enterprise enterprise, @RequestParam("image") MultipartFile fileImage){	
//		ModelAndView modelAndview = new ModelAndView("redirect:/enterprise/listarProducts");	
//		this.selectedEnterprise.setDescription(enterprise.getDescription());
//		
//		try {
//			this.selectedEnterprise.setImagem(fileImage.getBytes());
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//
//		this.enterpriseRepository.save(this.selectedEnterprise);
//		
//		return modelAndview;
//	}
	
//	@GetMapping("/updateEnterprise/{id}")
//	public String showFormUpdateEnterprise(@PathVariable("id") Long id, Model model) {
//		model.addAttribute("enterprise", this.enterpriseSv.getById(id));
//		
//		return "/employer/formUpdateEnterprise";
//	}
//	
//	@PostMapping("/updateEnterprise/{id}")
//	public String updateEnterprise(@PathVariable("id") Long id, @ModelAttribute("enterprise") Enterprise enterprise) {
//		this.enterpriseSv.update(id, enterprise);
//		
//		return "redirect:/admin/getAllEnterprises";
//	}
}
