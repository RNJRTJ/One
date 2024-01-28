package squad25.comercioFacil.controllers;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import squad25.comercioFacil.models.Enterprise;
import squad25.comercioFacil.models.MarketPlace;
import squad25.comercioFacil.services.EnterpriseService;
import squad25.comercioFacil.services.MarketPlaceService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private MarketPlaceService marketSv;
	
	@Autowired
	private EnterpriseService enterpriseSv;
	
	//MarketPlaces:
	@GetMapping("/getAllMarkets")
	public String showMarketsPage(Model model) {
		model.addAttribute("markets", this.marketSv.getAll());
		
		return "/admin/marketsPage";
	}
	
	@GetMapping("/updateMarket/{id}")
	public String showFormUpdateMarket(@PathVariable("id") Long id, Model model) {
		model.addAttribute("market", this.marketSv.getById(id));
		model.addAttribute("enterprises", this.enterpriseSv.getAll());
		
		return "/admin/formUpdateMarket";
	}
	
	@PostMapping("/updateMarket/{id}")
	public String updateMarket(@PathVariable("id") Long id,  @ModelAttribute("market") MarketPlace market) {
		this.marketSv.update(id, market);
		
		return "redirect:/admin/getAllMarkets";
	}
	
	@GetMapping("/saveMarket")
	public String showFormCreateMarket(Model model) {
		model.addAttribute("market", new MarketPlace());
		model.addAttribute("enterprises", this.enterpriseSv.getAll());
		
		return "/admin/formCreateMarket";
	}
	
	@PostMapping("/saveMarket")
	public String saveMarket(@ModelAttribute("market") MarketPlace market, @RequestParam List<Long> enterprises) {
		List<Object> listObj = enterprises.stream().map(this.enterpriseSv::getById).collect(Collectors.toList());
		
		market.setEnterprises(listObj.stream()
                .filter(Enterprise.class::isInstance)
                .map(Enterprise.class::cast)
                .collect(Collectors.toList()));
		
		this.marketSv.save(market, enterprises);
		
		return "redirect:/admin/getAllMarkets";
	}
	
	@DeleteMapping("/deleteMarket/{id}")
	public String deleteMarketById(@PathVariable("id") Long id) {
		this.marketSv.deleteById(id);
		
		return "redirect:/admin/getAllMarkets";
	}

	//Enterprises:
	@GetMapping("/getAllEnterprises")
	public String showEnterprisesPage(Model model) {
		model.addAttribute("enterprises", this.enterpriseSv.getAll());
		
		return "/admin/enterprisesPage";
	}
	
	@GetMapping("/updateEnterprise/{id}")
	public String showFormUpdateEnterprise(@PathVariable("id") Long id, Model model) {
		model.addAttribute("enterprise", this.enterpriseSv.getById(id));
		
		return "/admin/formUpdateEnterprise";
	}
	
	@PostMapping("/updateEnterprise/{id}")
	public String updateEnterprise(@PathVariable("id") Long id, @ModelAttribute("enterprise") Enterprise enterprise) {
		this.enterpriseSv.update(id, enterprise);
		
		return "redirect:/admin/getAllEnterprises";
	}
	
	@GetMapping("/saveEnterprise")
	public String showFormCreateEnterprise(Model model) {
		model.addAttribute("enterprise", new Enterprise());
		
		return "/admin/formCreateEnterprise";
	}
	
	@PostMapping("/saveEnterprise")
	public String saveEnterprise(@ModelAttribute("Enterprise") Enterprise enterprise) {
		this.enterpriseSv.save(enterprise);
		
		return "redirect:/admin/getAllEnterprises";
	}
	
	@DeleteMapping("/deleteEnterprise/{id}")
	public String deleteEnterpriseById(@PathVariable("id") Long id) {
		this.enterpriseSv.deleteById(id);
		
		return "redirect:/admin/getAllEnterprises";
	}	
}