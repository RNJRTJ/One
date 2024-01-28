package squad25.comercioFacil.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Contact {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idContact;
	
	@Column(nullable = false, length = 30)
	private String subject;
	
	@Column(nullable = false, length = 85)
	private String emailRecipient;

	@Column(nullable = false, columnDefinition = "TEXT")
	private String message;
	
	@ManyToOne
	@JoinColumn(name = "fk_id_user", nullable = false)
	private User user;
	
	public Contact() {	
	}

	public Long getIdContact() {
		return idContact;
	}

	public void setIdContact(Long idContact) {
		this.idContact = idContact;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public String getEmailRecipient() {
		return emailRecipient;
	}

	public void setEmailRecipient(String emailRecipient) {
		this.emailRecipient = emailRecipient;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}