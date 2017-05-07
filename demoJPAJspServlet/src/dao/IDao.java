package dao;

import java.util.Collection;

import metier.Adresse;
import metier.Contact;

public interface IDao {
	
	public int ajouterAdresse(Adresse a);
	public int ajouterContactAdresse(Contact c,Adresse a);
	public int modifierAdresse(Adresse a);
	public Collection<Contact> findAllContacts();
	public Adresse findAdresse(int id);
	public void deleteAdresse(Adresse a);

}
