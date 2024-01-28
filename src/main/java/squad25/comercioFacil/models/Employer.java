package squad25.comercioFacil.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
public class Employer extends User {
	
	@Column(length = 12)
	private String telephone;
	
	@OneToMany(mappedBy = "employer", cascade = CascadeType.ALL)
	private List<Enterprise> enterprises;
	
	public Employer() {	
		super();
	}

	public Employer(String telephone) {
		super();
		this.telephone = telephone;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
}