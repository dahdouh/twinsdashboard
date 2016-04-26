package com.sqli.gfi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.sqli.gfi.model.Evenement;
import com.sqli.gfi.model.Projet;
import com.sqli.gfi.model.Utilisateur;

@Repository
public class EventDaoImpl implements EventDao {

	@PersistenceContext 
    private EntityManager em;
	
	@Override
	public List<Evenement> getAllEvents() {
		Query query = em.createQuery("SELECT e FROM Evenement AS e");
        return query.getResultList();
	}

	@Override
	public void addEvent(Evenement event) {
		em.merge(event);
		em.flush();
	}

	@Override
	public Evenement getEventById(int idE) {
		return em.find(Evenement.class, idE);
	}

	@Override
	public void deleteEvent(int idE) {
		Evenement event_from_db = getEventById(idE);
		if(event_from_db != null) {
			em.remove(event_from_db);
			em.flush();
		}
	}

	@Override
	public Long countEvent() {
		Query query = em.createQuery("SELECT count(*) FROM Evenement as event");
		return (Long)query.getSingleResult();
	}
	
	@Override
	public Long countTeamemberEvent(int idM) {
		Query query = em.createQuery("SELECT count(*) FROM Evenement as event JOIN event.invitations inv WHERE inv.id_u = :idM");
		query.setParameter("idM", idM);
		return (Long)query.getSingleResult();
	}
	
	//___________________ Project event ___________________//
	//____________________________________________________//

	@Override
	public Projet getEventsByIdProject(int idP) {
		Query query = em.createQuery("SELECT  p FROM Projet p left join p.evenements e  where p.id_projet = :idP ");
		query.setParameter("idP", idP);
        return (Projet) query.getSingleResult();
	}

	@Override
	public List<Evenement> getEventsByIdTeamMember(int idM) {
		Query query = em.createQuery("SELECT  e FROM Evenement e left join e.invitations i where i.id_u = :idM");
		query.setParameter("idM", idM);
		return query.getResultList();
	}

	@Override
	public List<Utilisateur> getUserInvited(int idE) {
		Query query = em.createQuery("SELECT  i FROM Evenement e left join e.invitations i where e.id_evenement = :idE");
		query.setParameter("idE", idE);
		return query.getResultList();
	}

	

}
