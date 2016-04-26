package com.sqli.gfi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.sqli.gfi.model.DashboardManager;

/**
*
* @author karim 
*/
@Repository
public class DashboardDaoImpl implements DashboardDao {

	@PersistenceContext 
    private EntityManager em;
	
	@Override
	public List<DashboardManager> getAllDashboardManager() {
		Query query = em.createQuery("SELECT dash FROM DashboardManager AS dash GROUP BY dash.id_u");
        return query.getResultList(); 
	}
	
	@Override
	public List<DashboardManager> getDashboardManagersByCritere(String criteria, String libelle) {
		Query query = em.createQuery("SELECT dash FROM DashboardManager AS dash WHERE dash."+criteria+" like :libelle");
     	query.setParameter("libelle", "%"+libelle+"%");
     	return query.getResultList();
	}

	@Override
	public void addDashboardManager(DashboardManager dashboardmanager) {
		em.merge(dashboardmanager);
		em.flush();
	}
	public DashboardManager getDashboardManagerById(int idD) {
		return em.find(DashboardManager.class, idD);
	}

	@Override
	public void deleteDashboardManager(int idD) {
		DashboardManager d_from_db = getDashboardManagerById(idD);
		if(d_from_db != null) {
			em.remove(d_from_db);
			em.flush();
		}
	}

	@Override
	public Long countDashboardManager() {
		Query query = em.createQuery("SELECT count(*) FROM DashboardManager as dash");
		return (Long)query.getSingleResult();
	}

}
