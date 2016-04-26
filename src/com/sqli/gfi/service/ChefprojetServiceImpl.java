package com.sqli.gfi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sqli.gfi.dao.ChefprojetDao;
import com.sqli.gfi.model.ChefProjet;

@Service
@Transactional
public class ChefprojetServiceImpl implements ChefprojetService{

	 @Autowired 
	 private ChefprojetDao chefprojetDao;

	@Override
	@Transactional(readOnly = true)
	public List<ChefProjet> getAllChefprojets() {
		return chefprojetDao.getAllChefprojets();
	}

	@Override
	@Transactional(readOnly = true)
	public List<ChefProjet> getChefprojetByCriteria(String criteria, String libelle) {
		return chefprojetDao.getChefprojetByCriteria(criteria, libelle);
	}

	@Override
	public void addChefprojets(ChefProjet chefProjet) {
		chefprojetDao.addChefprojets(chefProjet);
		
	}

	@Override
	@Transactional(readOnly = true)
	public ChefProjet getChefprojetById(int idC) {
		return chefprojetDao.getChefprojetById(idC);
	}

	@Override
	public void deleteChef(int idC) {
		chefprojetDao.deleteChef(idC);
	}

	@Override
	@Transactional(readOnly = true)
	public Long countChefprojet() {
		return chefprojetDao.countChefprojet();
	}
	    
	    
	
}
