package squad25.comercioFacil.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import squad25.comercioFacil.enums.AccesLevel;
import squad25.comercioFacil.enums.SystemAlert;
import squad25.comercioFacil.models.Client;
import squad25.comercioFacil.models.Section;
import squad25.comercioFacil.models.User;
import squad25.comercioFacil.services.ClientService;
import squad25.comercioFacil.services.SectionService;

@Controller
public class NavigationController { // Atualizado 27.01 18:08;

	@Autowired
	private SectionService sectionSv;

	@Autowired
	private ClientService clientSv;

	private Section section;
	
	private User loggedUser;

	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("alert", SystemAlert.SUCCESSFUL_OPERATION);
		Double seuValor = 100.00;
		String nome = "Monitor Gamer Hero Full Hd 27'' G-sync 144hz Ips 1ms Aoc Cor Preto/Vermelho 110V/220V";
		model.addAttribute("nome", nome);
		model.addAttribute("seuValor", seuValor);
		return "index";
	}

	@GetMapping("/about")
	public String about() {
		return "pages/about";
	}

	@GetMapping("/contact")
	public String contact() {
		return "pages/contacts";
	}

	@GetMapping("/partnersClients")
	public String partClie() {
		return "pages/partnersClients";
	}

	@GetMapping("/adminSide")
	public String testeSide() {
		return "admin/marketsPage";
	}

	@GetMapping("/employerAdmin")
	public String showEnterprisesPage() {

		if (this.section != null) {
			if (this.section.getUser().getAccesLevel().equals(AccesLevel.EMPLOYER)) {
				return "redirect:/employer/id=" + this.section.getUser().getIdUser() + "/getAllEnterprises";
			} else {
				return "redirect:/employerAdmin"; // Você não possui acesso a esta seção;
			}
		} else {
			return "redirect:/"; // Faça login para continuar;
		}
	}

	@GetMapping("/notfications")
	public String notifications() {
		return "employer/notificationsPage";
	}

	@GetMapping("/prodEnterprise")
	public String productEnterprise() {
		return "product/productEnterprise";
	}

	@GetMapping("/login")
	public String showLoginPage() {
		return "user/loginPage";
	}

	@PostMapping("/login")
	public String loginClient(@RequestParam String email, @RequestParam String password) {
		Client user = this.clientSv.getByEmailAndPassword(email, password);

//		if (user != null) {
//			this.sectionSv.save(new Section(user));
//			this.loggedUser = user;
//		} else {
//
//			return "redirect:/login?login=false";
//		}

		
		
		if (this.section != null) {
			if (user != null) {
				this.sectionSv.logout(this.section.getIdSection());
				this.section = new Section(user);
				this.sectionSv.save(this.section);
//				this.loggedUser = user;
			} else {
				return "redirect:/login?login=false";
			}
			
		} else {
			if (user != null) {
				this.section = new Section(user);
				this.sectionSv.save(this.section);
//				this.loggedUser = user;
			} else {
				return "redirect:/login?login=false";
			}
		}

		return "redirect:/login?login=true";
	}

	@GetMapping("/cadClient")
	public String cadClient() {
		return "client/register";
	}

	@GetMapping("/help")
	public String help() {
		return "pages/help";
	}
}