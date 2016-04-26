package com.sqli.gfi.service;

import java.util.List;

import com.sqli.gfi.model.Equipe;
import com.sqli.gfi.model.MembreEquipe;
import com.sqli.gfi.model.Projet;

public interface EquipeService {
	//___________________________ team member __________________________//
	//__________________________________________________________________//
	public List<MembreEquipe> getAllMembreEquipe();

	public List<MembreEquipe> getmembresEquipeByCriteria(String criteria,
			String libelle);

	public void addmembreEquipe(MembreEquipe membreEquipe);

	public MembreEquipe getmembreEquipeById(int idM);

	public void deletemembreEquipe(int idM);

	public Long countmembreEquipe();

	//___________________________ team  ________________________________//
    //__________________________________________________________________//

	public List<Equipe> getAllTeams();

	public void addTeam(Equipe equipe);
	
	public Equipe getTeamById(int idT);
	
	public void deleteTeam(int idT);
	
	public Projet getTeamsByIdProject(int idP);
	
	public List<Projet> getTeamsByIdClient(int idE);

	public List<Equipe> getTeamsNotworksInProject(int idP);
	
	public void deleteTeamproject(int idP, int idE);
	
	//__________________________ team  memeber__________________________//
    //__________________________________________________________________//
	
	public List<Equipe>  getUsersByIdTeam(int idE);
	
	public Long countEquipe();
	
	public Long countTeamClient(int idC);

}
