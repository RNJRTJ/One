package squad25.comercioFacil.models;

import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="marketplace")
public class MarketPlace {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMarket;
	
	@Column(nullable = false)
	private String nameMarket;
	
	@Column(nullable = false, columnDefinition = "TEXT")
	private String mapUrl;
	
	@Column(nullable = false, columnDefinition = "TEXT")
	private String description;
	
	@OneToMany(mappedBy = "market", cascade = CascadeType.ALL)
	private List<Enterprise> enterprises;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_id_address", nullable = false)
	private Address address;
	
	public MarketPlace() {
	}

	public Long getIdMarket() {
		return idMarket;
	}

	public void setIdMarket(Long idMarket) {
		this.idMarket = idMarket;
	}

	public String getNameMarket() {
		return nameMarket;
	}

	public void setNameMarket(String nameMarket) {
		this.nameMarket = nameMarket;
	}

	public String getMapUrl() {
		return mapUrl;
	}

	public void setMapUrl(String mapUrl) {
		this.mapUrl = mapUrl;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Enterprise> getEnterprises() {
		return enterprises;
	}

	public void setEnterprises(List<Enterprise> enterprises) {
		this.enterprises = enterprises;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
}