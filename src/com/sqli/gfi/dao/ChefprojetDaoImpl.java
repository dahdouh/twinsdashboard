package com.sqli.gfi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.sqli.gfi.model.ChefProjet;
import com.sqli.gfi.model.DashboardManager;

@Repository
public class ChefprojetDaoImpl implements ChefprojetDao {

	 @PersistenceContext 
	 private EntityManager em;

	@Override
	public List<ChefProjet> getAllChefprojets() {
		Query query = em.createQuery("SELECT chef FROM ChefProjet AS chef GROUP BY chef.id_u");
        return query.getResultList(); 
	}

	@Override
	public List<ChefProjet> getChefprojetByCriteria(String criteria, String libelle) {
		Query query = em.createQuery("SELECT chef FROM ChefProjet AS chef WHERE chef."+criteria+" like :libelle");
     	query.setParameter("libelle", "%"+libelle+"%");
     	return query.getResultList();
	}

	@Override
	public void addChefprojets(ChefProjet chefProjet) {
		em.merge(chefProjet);
		em.flush();		
	}

	@Override
	public ChefProjet getChefprojetById(int idC) {
		return em.find(ChefProjet.class, idC);
	}

	public ChefProjet getChefProjetById(int idC) {
		return em.find(ChefProjet.class, idC);
	}
	
	@Override
	public void deleteChef(int idC) {
		ChefProjet chef_from_db = getChefProjetById(idC);
		if(chef_from_db != null) {
			em.remove(chef_from_db);
			em.flush();
		}
		
	}

	@Override
	public Long countChefprojet() {
		Query query = em.createQuery("SELECT count(*) FROM ChefProjet as chef");
		return (Long)query.getSingleResult();
	}
	 
	 
	    
}
