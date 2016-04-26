/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sqli.gfi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sqli.gfi.dao.UtilisateurDao;
import com.sqli.gfi.model.DashboardManager;
import com.sqli.gfi.model.Utilisateur;

/**
 *
 * @author karim
 */
@Service
@Transactional
public class UtilisateurServiceImpl implements UtilisateurService{

    @Autowired 
    private UtilisateurDao utilisateurDao;
    
    
    @Override
    @Transactional(readOnly = true)
	public Utilisateur getUtilisateurById(int idU) {
		return utilisateurDao.getUtilisateurById(idU);
	}
    
     
    @Transactional(readOnly = true)
	public Utilisateur getUtilisateurByIdCompte(int idCompte) {
		return utilisateurDao.getUtilisateurByIdCompte(idCompte);
	}


	@Override
	@Transactional(readOnly = true)
	public List<Utilisateur> getAllUtilisateur() {
		return utilisateurDao.getAllUtilisateur();
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Utilisateur> getAlluserNotInvited(int idE) {
		return utilisateurDao.getAlluserNotInvited(idE);
	} 


	@Override
	public void updateUtilisateurCompte(Utilisateur u_compte) {
		utilisateurDao.updateUtilisateurCompte(u_compte);
		
	}


	@Override
	@Transactional(readOnly = true)
	public List<Utilisateur> getAllUtilisateurTeamProject(int idP) {
		return utilisateurDao.getAllUtilisateurTeamProject(idP);
	}


	@Override
	@Transactional(readOnly = true)
	public List<Utilisateur> getUsersNotWorkInTeam(int idE) {
		return utilisateurDao.getUsersNotWorkInTeam(idE);
	}  
       
}
