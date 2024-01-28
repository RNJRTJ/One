package squad25.comercioFacil.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import squad25.comercioFacil.enums.State;

@Entity
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAddress;
	
	@Column(nullable = false)
	private State state;
	
	@Column(nullable = false)
	private String city;
	
	@Column(nullable = false)
	private String neighborhood;
	
	@Column(nullable = false)
	private String street;

	@OneToOne(mappedBy = "address")
	private MarketPlace marketPlace;
	
	public Address() {
	}
	
	public Long getIdAddress() {
		return idAddress;
	}
	
	public void setIdAddress(Long idAddress) {
		this.idAddress = idAddress;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public MarketPlace getMarketPlace() {
		return marketPlace;
	}

	public void setMarketPlace(MarketPlace marketPlace) {
		this.marketPlace = marketPlace;
	}	
}