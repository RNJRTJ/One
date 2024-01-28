package squad25.comercioFacil.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Section {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idSection;
	
	@ManyToOne
	@JoinColumn(name = "fk_id_user", nullable = false)
	private User user;
	
	public Section() {
	}

	public Section(User user) {
		this.user = user;
	}

	public Long getIdSection() {
		return idSection;
	}

	public void setIdSection(Long idSection) {
		this.idSection = idSection;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}