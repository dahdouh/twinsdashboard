package com.sqli.gfi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.sqli.gfi.model.Statut;

@Repository
public class StatutDaoImpl implements StatutDao {

	@PersistenceContext 
	private EntityManager em;
	
	@Override
	public List<Statut> getAllStatut() {
		Query query = em.createQuery("SELECT st FROM Statut AS st GROUP BY st.id_statut");
		return  query.getResultList();
	}

	@Override
	public Statut getStatutById(int idSt) {
		return em.find(Statut.class, idSt);
	}

}
