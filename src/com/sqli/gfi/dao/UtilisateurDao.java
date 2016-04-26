/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sqli.gfi.dao;

import java.util.List;

import com.sqli.gfi.model.DashboardManager;
import com.sqli.gfi.model.Utilisateur;

/**
 *
 * @author karim
 */
public interface UtilisateurDao {

	// authentification methods
	public Utilisateur getUtilisateurById(int idU);

	public Utilisateur getUtilisateurByIdCompte(int idCompte);

	// manage account
	public List<Utilisateur> getAllUtilisateur();

	public List<Utilisateur> getAlluserNotInvited(int idE);

	public List<Utilisateur> getAllUtilisateurTeamProject(int idP);

	public void updateUtilisateurCompte(Utilisateur u_compte);

	public List<Utilisateur> getUsersNotWorkInTeam(int idE);
}
