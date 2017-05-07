package presentation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import metier.Adresse;
import metier.Contact;
import metier.Film;
import metier.LongMetrage;
import metier.TeleFilm;

public class Lanceur {

	public static void main(String[] args) {
		// 1: Ouverture de l'unité de persistance 
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("demojpa-pu");
		EntityManager em = emf.createEntityManager();
		
		// 2: Ouverture de la transaction 
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		// 3: Création d'un objet métier
		Adresse s = new Adresse();
		s.setVille("LYON");
		s.setNumRue("120 rue Massena");
		s.setCodePostal("69006");
		Contact c = new Contact();
		c.setNom("Christian");
		c.setPrenom("Eddy");
		c.setEmail("service.huios@gmail.com");		
		// Nécessité de @ManyToOne(cascade=CascadeType.PERSIST)
		// au-dessus de adresse dans classe Contact
		c.setAdresse(s);
		
		TeleFilm tf = new TeleFilm();
		tf.setChaine("TF1");
		tf.setNomFilm("Josephine...");
		LongMetrage lm = new LongMetrage();
		lm.setNomFilm("Film1");
		lm.setCinema("GAUMONT");
		TeleFilm tf2 = new TeleFilm();
		tf2.setChaine("TF1");
		tf2.setNomFilm("Les experts...");
		// Ajout en cascade pour une relation ManyToMany
		Set<Film> films = new HashSet<Film>();
		films.add(tf);
		films.add(lm);
		// Il faut setter du côté maître
		c.setFilms(films);
		
		// 4: Persistance de l'objet métier
		//avant le persist pas d'ID attribué
		System.out.println(c);
		
		em.persist(tf2);
		
		// Persistance en cascade pour une relation ManyToMany
		em.persist(c);
		//em.persist(lm);
		//em.persist(tf);
		//après le presist, un ID est attribué et tout de suite disponible
		System.out.println(c);
		System.out.println(s);
		System.out.println(tf2);
		
		// 5: Validation de la transaction
		tx.commit();
		
		// Récupération du film d'id=2
		Film f = em.find(Film.class, 2);
		System.out.println(f);
		//Modification du film d'id=2 (passage à un état détaché)
		f.setNomFilm("film modifié");
		//Mise à jour en bdd (nécessité de commencer une transaction)
		tx.begin();
		em.merge(f);
		tx.commit();
		
		// Récupération du film d'id=1
		Film f3 = em.find(Film.class, 1);
		System.out.println(f);
		//Suppression du film d'Id=1
		tx.begin();
		em.remove(f3);
		tx.commit();
		
		// Récupérer tous les films en bdd
		List<Film> listeFilms = em.createQuery("SELECT f from Film f").getResultList();
		for(Film fl : listeFilms) {
			System.out.println(fl);
		}
		
		// Récupérer tous les noms de films en bdd
		em.createQuery("SELECT f.nomFilm FROM Film f").getResultList();
		
		// Recherche des films par nom de film
		Query q = em.createQuery("SELECT f FROM Film f WHERE f.nomFilm=:leNom");
		q.setParameter("leNom", "Film1");
		List<Film> listeFilms2=q.getResultList();
		for (Film fl : listeFilms2) {
			System.out.println(fl);
		}
		
		//Recherche tous les films qui contiennent un mot ou une lettre
		Query q2 = em.createQuery("SELECT f FROM Film f where f.nomFilm LIKE :leNom");
		q2.setParameter("leNom", "%l%");
		List<Film> listeFilms3=q2.getResultList();
		for (Film fl : listeFilms3) {
			System.out.println(fl);
		}
		
		//Exemple de getSingleResult()
		Film f4 = (Film) em.createQuery("SELECT f FROM Film f WHERE f.idFilm=2").getSingleResult();
		System.out.println(f4);
		
		// Exemple de jointure entre contact et adresse
		// Table avec contact et adresse du contact
		Query q3 = em.createQuery("SELECT c FROM Contact c LEFT JOIN c.adresse");
		List<Contact> listeContact=q3.getResultList();
		for (Contact co : listeContact) {
			System.out.println(c);
		}
		
		// Appel d'une requête nommée
		Query q4 = em.createNamedQuery("Contact.findAll");
		List<Contact> lst = q4.getResultList();
		for (Contact co : lst) {
			System.out.println(co);
		}
		
		Query q5 = em.createNamedQuery("Adresse.findAll");
		List<Adresse> lst2 = q5.getResultList();
		for (Adresse ad : lst2) {
			System.out.println(ad);
		}
		
		
		Query q6 = em.createNamedQuery("Adresse.findbyRue");
		q6.setParameter("rue", "%Mas%");
		List<Adresse> lst3 = q6.getResultList();
		for (Adresse ad : lst3) {
			System.out.println(ad);
		}
		
		// 6: Fermeture de l'unité de persistance
		em.close();
		emf.close();
	}

}
