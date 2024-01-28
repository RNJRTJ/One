package squad25.comercioFacil.models;

import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Enterprise {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEnterprise;
	
	@Column(nullable = false)
	private String fantasyName;
	
	@Column(nullable = false)
	private String cnpj;
	
	@Column(nullable = false)
	private int numStore;
	
	@Column(nullable = false, columnDefinition = "TEXT")
	private String description;
	
    @Column(columnDefinition = "longblob")
	private byte[] image;
	
    @ManyToOne
    @JoinColumn(name = "fk_id_user", nullable = false)
    private Employer employer;

    @OneToMany(mappedBy = "enterprise", cascade = CascadeType.ALL)
	private List<Product> products;
	
	@ManyToOne
	@JoinColumn(name = "fk_id_market", nullable = false)
	private MarketPlace market;
	
	public Enterprise() {	 
	}

	public Long getIdEnterprise() {
		return idEnterprise;
	}

	public void setIdEnterprise(Long idEnterprise) {
		this.idEnterprise = idEnterprise;
	}

	public String getFantasyName() {
		return fantasyName;
	}

	public void setFantasyName(String fantasyName) {
		this.fantasyName = fantasyName;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public int getNumStore() {
		return numStore;
	}

	public void setNumStore(int numStore) {
		this.numStore = numStore;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public Employer getEmployer() {
		return employer;
	}

	public void setEmployer(Employer employer) {
		this.employer = employer;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public MarketPlace getMarket() {
		return market;
	}

	public void setMarket(MarketPlace market) {
		this.market = market;
	}
}