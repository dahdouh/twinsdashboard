package com.sqli.gfi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sqli.gfi.dao.EquipeDao;
import com.sqli.gfi.model.Equipe;
import com.sqli.gfi.model.MembreEquipe;
import com.sqli.gfi.model.Projet;

@Service
@Transactional
public class EquipeServiceImpl implements EquipeService{

	@Autowired 
	private EquipeDao  equipeDao;	
	
	//__________________________ team memeber___________________________//
    //__________________________________________________________________//
	@Override
	@Transactional(readOnly = true)
	public List<MembreEquipe> getAllMembreEquipe() {
		return equipeDao.getAllMembreEquipe();
	}

	@Override
	@Transactional(readOnly = true)
	public List<MembreEquipe> getmembresEquipeByCriteria(String criteria, String libelle) {
		return equipeDao.getmembresEquipeByCriteria(criteria, libelle);
	}

	@Override
	public void addmembreEquipe(MembreEquipe membreEquipe) {
		equipeDao.addmembreEquipe(membreEquipe);		
	}

	@Override
	@Transactional(readOnly = true)
	public MembreEquipe getmembreEquipeById(int idM) {
		return equipeDao.getmembreEquipeById(idM);
	}

	@Override
	public void deletemembreEquipe(int idM) {
		equipeDao.deletemembreEquipe(idM);
	}

	@Override
	@Transactional(readOnly = true)
	public Long countmembreEquipe() {
		return equipeDao.countmembreEquipe();
	}

	//___________________________    team  _____________________________//
    //__________________________________________________________________//
	
	@Override
	@Transactional(readOnly = true)
	public List<Equipe> getAllTeams() {
		return equipeDao.getAllTeams();
	}

	@Override
	@Transactional(readOnly = true)
	public void addTeam(Equipe equipe) {
		equipeDao.addTeam(equipe);
	}

	@Override
	public Equipe getTeamById(int idT) {
		return equipeDao.getTeamById(idT);
	}

	@Override
	public void deleteTeam(int idT) {
		equipeDao.deleteTeam(idT);
		
	}

	@Override
	public Projet getTeamsByIdProject(int idP) {
		return equipeDao.getTeamsByIdProject(idP);
	}
	
	@Override
	public List<Projet> getTeamsByIdClient(int idE) {
		return equipeDao.getTeamsByIdClient(idE);
	}

	@Override
	public List<Equipe> getTeamsNotworksInProject(int idP) {
		return equipeDao.getTeamsNotworksInProject(idP);
	}

	@Override
	public void deleteTeamproject(int idP, int idE) {
		equipeDao.deleteTeamproject(idP, idE);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Equipe> getUsersByIdTeam(int idE) {
		return equipeDao.getUsersByIdTeam(idE);
	}

	@Override
	public Long countEquipe() {
		return equipeDao.countEquipe();
	}

	@Override
	public Long countTeamClient(int idC) {
		return equipeDao.countTeamClient(idC);
	}	

}
