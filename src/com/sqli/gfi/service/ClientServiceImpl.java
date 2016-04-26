package com.sqli.gfi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sqli.gfi.dao.ClientDao;
import com.sqli.gfi.model.Client;

@Service
@Transactional
public class ClientServiceImpl implements ClientService{

	@Autowired 
    private ClientDao clientDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Client> getAllClients() {
		return clientDao.getAllClients();
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Client> getClientByCriteria(String criteria, String libelle) {
		return clientDao.getClientByCriteria(criteria, libelle);
	}

	@Override
	public void addClient(Client client) {
		clientDao.addClient(client);
	}

	@Override
	@Transactional(readOnly = true)
	public Client getClientById(int idC) {
		return clientDao.getClientById(idC);
	}

	@Override
	public void deleteClient(int idC) {
		clientDao.deleteClient(idC);
	}

	@Override
	public Long countClient() {
		// TODO Auto-generated method stub
		return clientDao.countClient();
	}

}
