package com.sqli.gfi.dao;

import java.util.List;

import com.sqli.gfi.model.Client;

public interface ClientDao {
	
	public List<Client> getAllClients();
	public List<Client> getClientByCriteria(String criteria, String libelle);
	public void addClient(Client client);
	public Client getClientById(int idC);
	public void deleteClient(int idC);
	public Long countClient();

}
