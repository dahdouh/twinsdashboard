package com.sqli.gfi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.sqli.gfi.model.Sprint;

@Repository
public class SprintDaoImpl implements SprintDao {

	@PersistenceContext 
	private EntityManager em;

	
	@Override
	public List<Sprint> getAllSprint(int idP) {
		Query query = em.createQuery("select sp from Sprint sp WHERE sp.projet.id_projet=:idProjet ORDER BY sp.date_debut");
		query.setParameter("idProjet", idP);
		return query.getResultList();
	}

	@Override
	public void addSprint(Sprint sprint) {
		em.merge(sprint);
		em.flush();
	}

	@Override
	public Sprint getSprintById(int idS) {
		return em.find(Sprint.class, idS);
	}

	@Override
	public List<Sprint> getSprintsCompleted(int idP) {
		Query query = em.createQuery("select sp from Sprint sp WHERE sp.projet.id_projet=:idProjet AND sp.statut.libelle='Completed' ORDER BY sp.date_debut");
		query.setParameter("idProjet", idP);
		return query.getResultList();
	}

	@Override
	public List<Sprint> getSprintsInprogress(int idP) {
		Query query = em.createQuery("select sp from Sprint sp WHERE sp.projet.id_projet=:idProjet AND sp.statut.libelle='In Progress' ORDER BY sp.date_debut");
		query.setParameter("idProjet", idP);
		return query.getResultList();
	}

	@Override
	public List<Sprint> getSprintsPending(int idP) {
		Query query = em.createQuery("select sp from Sprint sp WHERE sp.projet.id_projet=:idProjet AND sp.statut.libelle='Pending' ORDER BY sp.date_debut");
		query.setParameter("idProjet", idP);
		return query.getResultList();
	}

	@Override
	public List<Sprint> getSprints(int idP) {
		Query query = em.createQuery("select sp from Sprint sp WHERE sp.projet.id_projet=:idProjet");
		query.setParameter("idProjet", idP);
		return query.getResultList();
	}

}
