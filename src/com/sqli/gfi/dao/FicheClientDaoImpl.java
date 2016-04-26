package com.sqli.gfi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.sqli.gfi.model.DashboardManager;
import com.sqli.gfi.model.FicheClient;
import com.sqli.gfi.model.MembreEquipe;

@Repository
public class FicheClientDaoImpl implements FicheClientDao {

	@PersistenceContext 
	private EntityManager em;

	@Override
	public List<FicheClient> getAllFicheClient() {
		Query query = em.createQuery("from FicheClient");
		return  query.getResultList();
	}

	@Override
	public void addFicheclient(FicheClient ficheclient) {
		em.merge(ficheclient);
		em.flush();
		
	}

	@Override
	public FicheClient getFicheclientById(int idF) {
		return em.find(FicheClient.class, idF);
	}

	@Override
	public void deleteFicheclient(int idF) {
		FicheClient fiche_from_db = getFicheclientById(idF);
		System.out.println("########################" + fiche_from_db);
		if(fiche_from_db != null) {
			em.remove(fiche_from_db);
			em.flush();
		}
	}

	@Override
	public Long countFicheclient() {
		Query query = em.createQuery("SELECT count(*) FROM FicheClient as dash");
		return (Long)query.getSingleResult();
	}
	
}
