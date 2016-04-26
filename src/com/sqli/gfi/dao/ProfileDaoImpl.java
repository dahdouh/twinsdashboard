package com.sqli.gfi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.sqli.gfi.model.Profil;

@Repository
public class ProfileDaoImpl implements ProfileDao {
	@PersistenceContext 
	private EntityManager em;

	 
	public List<Profil> getAllProfils() {
		Query query = em.createQuery("select p from Profil p ORDER BY p.titre");
		return query.getResultList();
	}

	 
	public Profil getByProfilById(int idP) {
		
		return em.find(Profil.class, idP);
	}

	 
	public void addProfil(Profil p) {
		em.merge(p);
		em.flush();		
	}

	 
	public void deleteProfil(int idP) {
		Profil p_from_db = getByProfilById(idP);
		if(p_from_db != null) {
			em.remove(p_from_db);
			em.flush();
		} else {
			System.out.println("le profile n'existe pas dans la base de données");
		}
				
	} 
	
}
