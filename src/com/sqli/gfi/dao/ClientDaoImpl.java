package com.sqli.gfi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.sqli.gfi.model.ChefProjet;
import com.sqli.gfi.model.Client;

@Repository
public class ClientDaoImpl implements ClientDao {

	@PersistenceContext 
	private EntityManager em;
	
	@Override
	public List<Client> getAllClients() {
		Query query = em.createQuery("SELECT client FROM Client AS client GROUP BY client.id_u");
        return query.getResultList(); 
	}

	@Override
	public List<Client> getClientByCriteria(String criteria, String libelle) {
		
		Query query = em.createQuery("SELECT client FROM Client AS client WHERE client."+criteria+" like :libelle");
     	query.setParameter("libelle", "%"+libelle+"%");
     	return query.getResultList();
	}

	@Override
	public void addClient(Client client) {
		em.merge(client);
		em.flush();			
	}

	@Override
	public Client getClientById(int idC) {
		return em.find(Client.class, idC);
	}

	@Override
	public void deleteClient(int idC) {
		Client client_from_db = getClientById(idC);
		if(client_from_db != null) {
			em.remove(client_from_db);
			em.flush();
		}
		
	}

	@Override
	public Long countClient() {
		Query query = em.createQuery("SELECT count(*) FROM Client as client");
		return (Long)query.getSingleResult();
	}

}
