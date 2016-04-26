package com.sqli.gfi.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

@Repository
public class TableauBordDaoImpl implements TableauBordDao{
	
	@PersistenceContext
	private EntityManager em;
	
	 
	public Long countCollaborateurBySession(int idS) {
		Query query = em.createQuery("SELECT count(*) FROM CollaborateurSession cs where cs.pk.session.id_session=:idS ");
		query.setParameter("idS", idS);
		return (Long)query.getSingleResult();
	}
	
	 
	public Long countAbsenceBySession(int idS) {
		Query query = em.createQuery("SELECT count(*) FROM Absence AS abs WHERE abs.collaborateurSession.pk.session.id_session=:idS");
		query.setParameter("idS", idS);
		return (Long)query.getSingleResult();
	}

}
