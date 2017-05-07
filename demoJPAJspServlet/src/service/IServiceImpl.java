package service;

import java.util.Collection;

import dao.Dao;
import dao.IDao;
import metier.Adresse;
import metier.Contact;

public class IServiceImpl implements IService {
	private IDao idao = new Dao();
	
	@Override
	public int ajouterAdresse(Adresse a) {
		return idao.ajouterAdresse(a);
	}

	@Override
	public int ajouterContactAdresse(Contact c, Adresse a) {
		return idao.ajouterContactAdresse(c, a);
	}

	@Override
	public int modifierAdresse(Adresse a) {
		return idao.modifierAdresse(a);
	}

	@Override
	public Collection<Contact> findAllContacts() {
		return idao.findAllContacts();
	}

	@Override
	public Adresse findAdresse(int id) {
		return idao.findAdresse(id);
	}

	@Override
	public void deleteAdresse(Adresse a) {
		idao.deleteAdresse(a);
	}

}
