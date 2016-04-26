package com.sqli.gfi.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.sqli.gfi.model.Equipe;
import com.sqli.gfi.model.MembreEquipe;
import com.sqli.gfi.model.Projet;
import com.sqli.gfi.model.Utilisateur;

/**
*
* @author karim 
*/
@Repository
public class EquipeDaoImpl implements EquipeDao {

	@PersistenceContext 
    private EntityManager em;
	
	//___________________________ team memeber _________________________//
    //__________________________________________________________________//
	@Override
	public List<MembreEquipe> getAllMembreEquipe() {
		Query query = em.createQuery("SELECT membre FROM MembreEquipe AS membre GROUP BY membre.id_u");
        return query.getResultList();
	}

	@Override
	public List<MembreEquipe> getmembresEquipeByCriteria(String criteria, String libelle) {
		Query query = em.createQuery("SELECT membre FROM MembreEquipe AS membre WHERE membre."+criteria+" like :libelle");
     	query.setParameter("libelle", "%"+libelle+"%");
     	return query.getResultList();
	}

	@Override
	public void addmembreEquipe(MembreEquipe membreEquipe) {
		em.merge(membreEquipe);
		em.flush();
	}

	@Override
	public MembreEquipe getmembreEquipeById(int idM) {
		return em.find(MembreEquipe.class, idM);
	}

	@Override
	public void deletemembreEquipe(int idM) {
		MembreEquipe m_from_db = getmembreEquipeById(idM);
		if(m_from_db != null) {
			em.remove(m_from_db);
			em.flush();
		}
	}

	@Override
	public Long countmembreEquipe() {
		Query query = em.createQuery("SELECT count(*) FROM MembreEquipe as membre");
		return (Long)query.getSingleResult();
	}

	//___________________________    team  _____________________________//
    //__________________________________________________________________//

	
	@Override
	public List<Equipe> getAllTeams() {
		Query query = em.createQuery("SELECT e FROM Equipe AS e ORDER BY e.nom");
        return query.getResultList();
	}

	@Override
	public void addTeam(Equipe equipe) {
		em.merge(equipe);
		em.flush();
	}

	@Override
	public Equipe getTeamById(int idT) {
		return em.find(Equipe.class, idT);
	}

	@Override
	public void deleteTeam(int idT) {
		
		
//		Equipe e_from_db = getTeamById(idT);
//		if(e_from_db != null) {
//			em.remove(e_from_db);
//			em.flush();
//		}
//		
//		Projet projet = em.find(Projet.class, idP);
		Query query = em.createQuery("SELECT  p FROM Equipe e left join e.projets p  where e.id_equipe = :idT ");
		query.setParameter("idT", idT);
        List<Projet> projets = query.getResultList();
        
	        for(Projet pr : projets) {
	        	if(pr != null) {
					Equipe equipe = getTeamById(idT);
					System.out.println("##############################"+pr);
					System.out.println("??????????????????????????????"+equipe);
					if(equipe != null) {
						pr.getEquipes().remove(equipe);
						em.flush();
					}
	        	} 
	        }
	     
	      Query q = em.createQuery("SELECT  u FROM Utilisateur u WHERE u.equipe.id_equipe = :idT ");
		  q.setParameter("idT", idT);
	      List<Utilisateur> members = q.getResultList();
	        
	      for(Utilisateur user : members) {
	        	if(user != null) {
					user.setEquipe(null);
					em.merge(user);
					em.flush();
	        	} 
	        }
	      
	        Equipe equipe = getTeamById(idT);
        	em.remove(equipe);
			em.flush();
        
        
        
        
	}

	@Override
	public Projet getTeamsByIdProject(int idP) {
		Query query = em.createQuery("SELECT  p FROM Projet p left join p.equipes e  where p.id_projet = :idP ");
		query.setParameter("idP", idP);
        return (Projet) query.getSingleResult();
	}
	
	@Override
	public List<Projet> getTeamsByIdClient(int idE) {
		Query query = em.createQuery("SELECT DISTINCT(p) FROM Projet p left join p.equipes e  where p.id_projet IN (SELECT  p.id_projet FROM Projet p join p.ficheClient f join f.client c where c.id_u = :idE) ");
		query.setParameter("idE", idE);
        return  query.getResultList();
	}

	@Override
	public List<Equipe> getTeamsNotworksInProject(int idP) {
		
		Query query = em.createQuery("SELECT  p FROM Projet p  where p.id_projet =:idP");
		query.setParameter("idP", idP);
    	Projet projet  = (Projet) query.getSingleResult();
    	List<Equipe> list_equipes = new ArrayList<Equipe>();
		if(!projet.getEquipes().isEmpty()) {
			Query qq = em.createQuery("SELECT  e.id_equipe FROM Projet p left join p.equipes e  where p.id_projet =:idP");
	    	qq.setParameter("idP", idP);
	    	List<Integer> list_equipes_projets = qq.getResultList();
	    	
	        list_equipes = new ArrayList<Equipe>();
	    	
		    	Query q = em.createQuery("SELECT e FROM Equipe e WHERE e.id_equipe NOT IN (:list_equipes_projets)");
		    	q.setParameter("list_equipes_projets", list_equipes_projets);
		    	list_equipes = q.getResultList();
	  }else {
	    		list_equipes = getAllTeams();
	   }	    	
		
		return list_equipes;
		
	}

	@Override
	public void deleteTeamproject(int idP, int idE) {
		Projet projet = em.find(Projet.class, idP);
//		for(Equipe e : projet.getEquipes()) {
//			
//		}
		Equipe e_from_db = getTeamById(idE);
		if(e_from_db != null) {
			projet.getEquipes().remove(e_from_db);
			em.flush();
		}
		
	}

	//___________________________ team  memeber_________________________//
    //__________________________________________________________________//
	
	@Override
	public List<Equipe> getUsersByIdTeam(int idE) {
		Query query = em.createQuery("SELECT u FROM Utilisateur u WHERE u.equipe.id_equipe = :idE");
		query.setParameter("idE", idE);
	    return query.getResultList();
	}

	@Override
	public Long countEquipe() {
		Query query = em.createQuery("SELECT count(*) FROM Equipe as e");
		return (Long)query.getSingleResult();
	}

	@Override
	public Long countTeamClient(int idC) {
		Query query = em.createQuery("SELECT count(e) FROM Projet p left join p.equipes e  where p.id_projet IN (SELECT  p.id_projet FROM Projet p join p.ficheClient f join f.client c where c.id_u = :idC) ");
		query.setParameter("idC", idC);
		return (Long)query.getSingleResult();
	}

	
	
	
	

	

}
