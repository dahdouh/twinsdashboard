package com.sqli.gfi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.sqli.gfi.model.Attachement;

@Repository
public class AttachementDaoImpl implements AttachementDao {

	@PersistenceContext 
	private EntityManager em;
	
	@Override
	public List<Attachement> getFilesByIdSprint(int idS) {
		Query query = em.createQuery("select a  FROM Attachement a WHERE a.sprint.id_sprint=:idS ORDER BY a.date_attachement");
		query.setParameter("idS", idS);
		return query.getResultList();
	}
	
	@Override
	public List<Attachement> getFilesByIdTask(int idT) {
		Query query = em.createQuery("select a  FROM Attachement a WHERE a.task.id_task=:idT ORDER BY a.date_attachement");
		query.setParameter("idT", idT);
		return query.getResultList();
	}

	@Override
	public List<Attachement> getFilesByIdProject(int idP) {
		Query query = em.createQuery("select a  FROM Attachement a WHERE a.sprint.projet.id_projet=:idP ORDER BY a.date_attachement");
		query.setParameter("idP", idP);
		return query.getResultList();
	}
	
	@Override
	public Attachement getAttachementById(int idA) {
		return em.find(Attachement.class, idA);
	}

	@Override
	public void addAttechement(Attachement file) {
		em.merge(file);
		em.flush();
	}

	@Override
	public void deleteAttachment(int idA) {
		Attachement a_from_db = getAttachementById(idA);
		if(a_from_db != null) {
			em.remove(a_from_db);
			em.flush();
		}
	}


}
