package com.sqli.gfi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.sqli.gfi.model.Projet;
import com.sqli.gfi.model.Utilisateur;

@Repository
public class ProjetDaoImpl implements ProjetDao {
	
	@PersistenceContext 
	private EntityManager em;

	@Override
	public List<Projet> getAllProjets() {
		Query query = em.createQuery("select p from Projet p ORDER BY p.date_creation");
		return query.getResultList();
	}

	@Override
	public void addProjet(Projet p) {
		em.merge(p);
		em.flush();	
	}

	@Override
	public Projet getProjetById(int idP) {
		return em.find(Projet.class, idP);
	}

	@Override
	public Projet getProjetByFicheClient(int idF) {
		Query query = em.createQuery("SELECT p FROM Projet AS p WHERE p.ficheClient.id_ficheClient=:idF");
     	query.setParameter("idF", idF);
     	return (Projet) org.springframework.dao.support.DataAccessUtils.singleResult(query.getResultList());
	}

	@Override
	public void deleteProjet(int idP) {
		Projet projet_from_db = getProjetById(idP);
		if(projet_from_db != null) {
			em.remove(projet_from_db);
			em.flush();
		}
		
	}

	@Override
	public Long countProjet() {
		Query query = em.createQuery("SELECT count(*) FROM Projet as projet");
		return (Long)query.getSingleResult();
	}
	
	@Override
	public long countTeamemberProjet(int idM) {
		Query query = em.createQuery("SELECT count(p.id_projet) FROM Equipe as e JOIN e.projets as p JOIN e.membres as m  WHERE m.id_u = :idM");
		query.setParameter("idM", idM);
		return (Long)query.getSingleResult();
	}

	@Override
	public List<Projet> getProjetByIdTeamMember(int idM) {
		Query query = em.createQuery("SELECT  p FROM Equipe e left join e.projets p left join e.membres m  where m.id_u = :idM");
		query.setParameter("idM", idM);
		return query.getResultList();
	}
	
	@Override
	public List<Projet> getProjetByIdClient(int idC) {
		Query query = em.createQuery("SELECT  p FROM Projet p join p.ficheClient f join f.client c where c.id_u = :idC");
		query.setParameter("idC", idC);
		return query.getResultList();
	}

	@Override
	public long countProjetClient(int idC) {
		Query query = em.createQuery("SELECT  count(p) FROM Projet p join p.ficheClient f join f.client c where c.id_u = :idC ");
		query.setParameter("idC", idC);
		return (Long)query.getSingleResult();
	}

	@Override
	public List<Utilisateur> getAllChefProjetClient(int idC) {
		Query query = em.createQuery("SELECT  cp FROM Projet p join p.chefprojet cp join p.ficheClient f join f.client c where c.id_u = :idC");
		query.setParameter("idC", idC);
		return query.getResultList();
	}
	
}
