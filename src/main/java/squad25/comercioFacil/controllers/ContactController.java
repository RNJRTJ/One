package squad25.comercioFacil.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import squad25.comercioFacil.models.Contact;
import squad25.comercioFacil.models.Employer;
import squad25.comercioFacil.services.ContactService;
import squad25.comercioFacil.services.EmployerService;

@Controller
@RequestMapping("/contact")
public class ContactController {

	@Autowired
	private ContactService contactSv;
	
	@Autowired
	private EmployerService employerSv;
	
	@PostMapping("/save/{idEnterprise}")
	public String save( @PathVariable("idEnterprise") Long idEnterprise, @ModelAttribute("contact") Contact contact) {
		Employer  employerOwner = this.employerSv.getByIdEnterprise(idEnterprise);
		
		contact.setUser(employerOwner);
		contact.setEmailRecipient(employerOwner.getEmail());
		
		this.contactSv.save(contact);
		
//		return "redirect:/isRegistered=" + true + "?showAlert=true";
		return "redirect:/";
	}
	
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		this.contactSv.deleteById(id);
		
		return "redirect:/isRegistered=" + true + "?showAlert=true";
	}
	
}