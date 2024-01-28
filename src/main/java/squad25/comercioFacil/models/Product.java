package squad25.comercioFacil.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import squad25.comercioFacil.enums.Category;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProduct;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private Double value;
	
	@Column(columnDefinition = "longblob")
	private byte[] image;
	
	@Column(nullable = false)
	private boolean inStock;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Category category;
	
	@ManyToOne
	@JoinColumn(name = "fk_id_enterprise",  nullable = false)
	private Enterprise enterprise;

	public Product() {		
	}
	
	public Long getIdProduct() {
		return idProduct;
	}
	
	public void setIdProduct(Long idProduct) {
		this.idProduct = idProduct;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Double getValue() {
		return value;
	}
	
	public void setValue(Double value) {
		this.value = value;
	}
	
	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}
	
	public boolean isInStock() {
		return inStock;
	}

	public void setInStock(boolean inStock) {
		this.inStock = inStock;
	}

	public Category getCategory() {
		return category;
	}
	
	public void setCategory(Category category) {
		this.category = category;
	}

	public Enterprise getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
	}
}