/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sqli.gfi.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.sqli.gfi.model.DashboardManager;
import com.sqli.gfi.model.Utilisateur;

/**
 *
 * @author karim 
 */
@Repository
public class UtilisateurDaoImpl implements UtilisateurDao {
    
    @PersistenceContext 
    private EntityManager em;
    
    
    
    // authnetification methods
     
	public Utilisateur getUtilisateurById(int idU) {
		return em.find(Utilisateur.class, idU);
	}
    
     
   	public Utilisateur getUtilisateurByIdCompte(int idCompte) {
       	Query query = em.createQuery("SELECT u FROM Utilisateur AS u WHERE u.compte.id_compte=:idCompte");
       	  query.setParameter("idCompte", idCompte);
       	  return (Utilisateur) query.getSingleResult();
   	}


   	@Override
	public List<Utilisateur> getAllUtilisateur() {
		Query query = em.createQuery("SELECT u FROM Utilisateur AS u WHERE u.compte.id_compte IS NULL ORDER BY u.nom");
        return query.getResultList();
	}
   	
   	@Override
	public List<Utilisateur> getAlluserNotInvited(int idE) {
		Query query = em.createQuery("SELECT  u FROM Utilisateur as u");
        return query.getResultList();
	}


	@Override
	public void updateUtilisateurCompte(Utilisateur u_compte) {
		em.merge(u_compte);
		em.flush();
		
	}


	@Override
	public List<Utilisateur> getAllUtilisateurTeamProject(int idP) {
		Query query = em.createQuery("SELECT u FROM Utilisateur AS u, Projet AS p WHERE p.id_projet=:idP ORDER BY u.nom");
		query.setParameter("idP", idP);
        return query.getResultList();
	}


	@Override
	public List<Utilisateur> getUsersNotWorkInTeam(int idE) {
		Query query = em.createQuery("SELECT u FROM Utilisateur AS u WHERE u.equipe.id_equipe!=:idE OR u.equipe.id_equipe IS NULL ORDER BY u.nom");
		query.setParameter("idE", idE);
        return query.getResultList();
	}

}
