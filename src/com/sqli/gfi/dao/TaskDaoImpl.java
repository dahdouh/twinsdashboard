package com.sqli.gfi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.sqli.gfi.model.Task;

@Repository
public class TaskDaoImpl implements TaskDao{

	@PersistenceContext 
	private EntityManager em;
	
	@Override
	public List<Task> getTasksByIdSprint(int idS) {
		Query query = em.createQuery("select t from Task t WHERE t.sprint.id_sprint=:idS ORDER BY t.date_debut");
		query.setParameter("idS", idS);
		return query.getResultList();
	}
	
	@Override
	public List<Task> getTasksByIdProject(int idP) {
		Query query = em.createQuery("select t from Task t WHERE t.sprint.projet.id_projet=:idP ORDER BY t.date_debut");
		query.setParameter("idP", idP);
		return query.getResultList();
	}

	@Override
	public void addTask(Task task) {
		em.merge(task);
		em.flush();
	}

	@Override
	public Task getTaskById(int idT) {
		return em.find(Task.class, idT);
	}

	@Override
	public void deleteTask(int idT) {
		Task t_from_db = getTaskById(idT);
		if(t_from_db != null) {
			em.remove(t_from_db);
			em.flush();
		}
	}

	@Override
	public List<Task> getTasksCompleted(int idS) {
		Query query = em.createQuery("select t from Task t WHERE t.sprint.id_sprint=:idS AND t.statut.libelle='Completed' ORDER BY t.date_debut");
		query.setParameter("idS", idS);
		return query.getResultList();
	}

	@Override
	public List<Task> getTasksInprogress(int idS) {
		Query query = em.createQuery("select t from Task t WHERE t.sprint.id_sprint=:idS AND t.statut.libelle='In Progress' ORDER BY t.date_debut");
		query.setParameter("idS", idS);
		return query.getResultList();
	}

	@Override
	public List<Task> getTasksPending(int idS) {
		Query query = em.createQuery("select t from Task t WHERE t.sprint.id_sprint=:idS AND t.statut.libelle='Pending' ORDER BY t.date_debut");
		query.setParameter("idS", idS);
		return query.getResultList();
	}

	@Override
	public List<Task> getTasksByIdTeamMember(int idM) {
		Query query = em.createQuery("select t, (t.date_fin-t.date_debut), (t.date_fin_effective-t.date_debut_effective) from Task t WHERE t.responsable.id_u=:idM");
		query.setParameter("idM", idM);
		return query.getResultList();
		
	}

	@Override
	public long countTeamemberMyTask(int idM) {
		Query query = em.createQuery("SELECT count(*) FROM Task as t WHERE t.responsable.id_u = :idM");
		query.setParameter("idM", idM);
		return (Long)query.getSingleResult();
	}


}
