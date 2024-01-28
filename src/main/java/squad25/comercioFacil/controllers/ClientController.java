package squad25.comercioFacil.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import squad25.comercioFacil.enums.SystemAlert;
import squad25.comercioFacil.models.Client;
import squad25.comercioFacil.services.ClientService;

@Controller
//@RequestMapping("/client")
public class ClientController {

	@Autowired
	private ClientService clientServ;
	
	@GetMapping("/isRegistered={isRegistered}")
	public String showAlert(Model model, @PathVariable("isRegistered") String isRegistered) {			
		model.addAttribute("alert", (Boolean.parseBoolean(isRegistered)) ? SystemAlert.SUCCESSFUL_OPERATION : SystemAlert.OPERATION_ERROR);
		
		return "index";
	}
	
	@GetMapping("/save")
	public String showCreateForm(Model model) {
		model.addAttribute("client", new Client());
		
		return "client/formCreateClient";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute("client") Client client) {
		
		if(this.clientServ.save(client) != null) {
//			return "redirect:/client/isRegistered=" + true + "?showAlert=true";
			return "redirect:/isRegistered=" + true + "?showAlert=true";
		}else {
//			return "redirect:/client/isRegistered=" + false + "?showAlert=true";
			return "redirect:/isRegistered=" + false + "?showAlert=true";
		}
	}
	
	@GetMapping("/update/{id}")
	public String showUpdateForm(Model model, @PathVariable("id") Long id) {
		
		return "client/formUpdateClient";
	}
	
	@PutMapping("/update/{id}")
	public String update(@PathVariable("id") Long id, @ModelAttribute("client") Client client) {
		
		if(this.clientServ.update(id, client) != null) {
//			return "redirect:/client/isRegistered=" + true + "?showAlert=true";
			return "redirect:/isRegistered=" + true + "?showAlert=true";
		}else {
//			return "redirect:/client/isRegistered=" + false + "?showAlert=true";
			return "redirect:/isRegistered=" + false + "?showAlert=true";
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		this.clientServ.deleteById(id);
		
		return "redirect:/isRegistered=" + true + "?showAlert=true";
	}
}