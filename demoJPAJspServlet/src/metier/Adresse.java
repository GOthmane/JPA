package metier;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
@NamedQueries({@NamedQuery(name="Adresse.findAll", query="SELECT a FROM Adresse a"),
			   @NamedQuery(name="Adresse.findbyRue",query="SELECT a FROM Adresse a WHERE a.numRue LIKE :rue")})
public class Adresse {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String numRue;
	private String ville;
	private String codePostal;
	@Transient
	private String commentaires;
	
	// 1 adresse correspond à 0 ou plusieurs contacts
	//,fetch=FetchType.LAZY : chargement tardif (contrairement à EAGER qui est immédiat)
	@OneToMany(mappedBy="adresse")
	private Collection<Contact> Contacts;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNumRue() {
		return numRue;
	}
	public void setNumRue(String numRue) {
		this.numRue = numRue;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	public String getCommentaires() {
		return commentaires;
	}
	public void setCommentaires(String commentaires) {
		this.commentaires = commentaires;
	}
	
	public Collection<Contact> getContacts() {
		return Contacts;
	}
	public void setContacts(Collection<Contact> contacts) {
		Contacts = contacts;
	}
	@Override
	public String toString() {
		return "Adresse [id=" + id + ", numRue=" + numRue + ", ville=" + ville + ", codePostal=" + codePostal
				+ ", commentaires=" + commentaires + "]";
	}
	
}
