package com.sqli.gfi.dao;

import java.util.List;

import com.sqli.gfi.model.Projet;
import com.sqli.gfi.model.Utilisateur;

public interface ProjetDao {
	public List<Projet> getAllProjets();

	public void addProjet(Projet p);

	public Projet getProjetById(int idP);

	public Projet getProjetByFicheClient(int idF);

	public void deleteProjet(int idP);

	public Long countProjet();

	public long countTeamemberProjet(int idM);
	
	public long countProjetClient(int idC);

	public List<Projet> getProjetByIdTeamMember(int idM);

	public List<Projet> getProjetByIdClient(int idC);
	
	public List<Utilisateur> getAllChefProjetClient(int idC);

}
