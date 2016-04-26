package com.sqli.gfi.dao;

import java.util.List;

import com.sqli.gfi.model.ChefProjet;

public interface ChefprojetDao {
	
	public List<ChefProjet> getAllChefprojets();
	public List<ChefProjet> getChefprojetByCriteria(String criteria, String libelle);
	public void addChefprojets(ChefProjet chefProjet);
	public ChefProjet getChefprojetById(int idC);
	public void deleteChef(int idC);
	public Long countChefprojet();
	
}
