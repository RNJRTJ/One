package squad25.comercioFacil.models;

import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;
import squad25.comercioFacil.enums.AccesLevel;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "user_type")
public abstract class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUser;
	
	@Column(nullable = false, columnDefinition = "TEXT")
	private String login;
		
	@Column(nullable = false, length = 25)
	private String password;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private AccesLevel accesLevel;
	
	@Column(nullable = false)
	private String userName;
	
	@Column(nullable = false, length = 85, unique = true)
	private String email;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL/*, orphanRemoval = true*/)
	private List<Contact> contatos;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Section> sections;

	public User() {
	}

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public AccesLevel getAccesLevel() {
		return accesLevel;
	}

	public void setAccesLevel(AccesLevel accesLevel) {
		this.accesLevel = accesLevel;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Contact> getContatos() {
		return contatos;
	}

	public void setContatos(List<Contact> contatos) {
		this.contatos = contatos;
	}

	public List<Section> getSections() {
		return sections;
	}

	public void setSections(List<Section> sections) {
		this.sections = sections;
	}
}