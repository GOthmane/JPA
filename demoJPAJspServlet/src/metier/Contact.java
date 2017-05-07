package metier;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name="Contact.findAll",query="SELECT c FROM Contact c")
public class Contact {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String nom;
	private String  prenom;
	private String email;
	
	// 0 ou plusieurs contacts ont 0 ou 1 adresse
	// PERSIST = effectue en cascade 
	// l'opération de persistance sur attribut adresse si objet 
	// de type contact est persisté 
	// ALL à éviter = toutes les opérations sont faites en cascade
	// ex: quand on supprime une adresse, on supprime
	// tous les contacts associés
	//,fetch=FetchType.LAZY : chargement tardif (contrairement à EAGER qui est immédiat)
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Adresse adresse;
	
	@ManyToMany(cascade=CascadeType.PERSIST)
	private Collection<Film> films;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public Collection<Film> getFilms() {
		return films;
	}

	public void setFilms(Collection<Film> films) {
		this.films = films;
	}

	@Override
	public String toString() {
		return "Contact [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", adresse=" + adresse
				+ ", films=" + films + "]";
	}

}
