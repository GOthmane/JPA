package metier;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;

@Entity
//HERITAGE AVEC TABLE UNIQUE
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_FILM")
//Pas besoin de @DiscriminatorValue car classe abstraite
//HERITAGE AVEC UNE TABLE POUR CHAQUE CLASSE
//@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
//HERITAGE AVEC UNE TABLE DE JOINTURE
//@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Film {
	@Id
	//HERITAGE AVEC TABLE UNIQUE
	@GeneratedValue(strategy=GenerationType.AUTO)
	//HERITAGE AVEC UNE TABLE POUR CHAQUE CLASSE
	//@GeneratedValue(strategy=GenerationType.TABLE)
	//HERITAGE AVEC UNE TABLE DE JOINTURE
	//@GeneratedValue(strategy=GenerationType.AUTO)
	private int idFilm;
	private String nomFilm;
	@ManyToMany(mappedBy="films")
	private Collection<Contact> contacts;
	
	public int getIdFilm() {
		return idFilm;
	}
	public void setId(int idFilm) {
		this.idFilm = idFilm;
	}
	public String getNomFilm() {
		return nomFilm;
	}
	public void setNomFilm(String nomFilm) {
		this.nomFilm = nomFilm;
	}
	public Collection<Contact> getContacts() {
		return contacts;
	}
	public void setContacts(Collection<Contact> contacts) {
		this.contacts = contacts;
	}
	@Override
	public String toString() {
		return "Film [idFilm=" + idFilm + ", nomFilm=" + nomFilm + ", contacts=" + contacts + "]";
	}
}
