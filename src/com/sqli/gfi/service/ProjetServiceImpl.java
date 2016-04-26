package com.sqli.gfi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sqli.gfi.dao.ProjetDao;
import com.sqli.gfi.model.Projet;
import com.sqli.gfi.model.Utilisateur;

@Service
@Transactional
public class ProjetServiceImpl implements ProjetService {
	@Autowired 
    private ProjetDao projetDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Projet> getAllProjets() {
		return projetDao.getAllProjets();
	}

	@Override
	public void addProjet(Projet p) {
		projetDao.addProjet(p);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Projet getProjetById(int idP) {
		return projetDao.getProjetById(idP);
	}

	@Override
	@Transactional(readOnly = true)
	public Projet getProjetByFicheClient(int idF) {
		return projetDao.getProjetByFicheClient(idF);
	}

	@Override
	public void deleteProjet(int idP) {
		projetDao.deleteProjet(idP);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Long countProjet() {
		return projetDao.countProjet();
	}
	
	@Override
	@Transactional(readOnly = true)
	public long countTeamemberProjet(int idM) {
		return projetDao.countTeamemberProjet(idM);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Projet> getProjetByIdTeamMember(int idM) {
		return projetDao.getProjetByIdTeamMember(idM);
	}

	@Override
	public List<Projet> getProjetByIdClient(int idC) {
		return projetDao.getProjetByIdClient(idC);
	}

	@Override
	public long countProjetClient(int idC) {
		return projetDao.countProjetClient(idC);
	}

	@Override
	public List<Utilisateur> getAllChefProjetClient(int idC) {
		return projetDao.getAllChefProjetClient(idC);
	}

}
