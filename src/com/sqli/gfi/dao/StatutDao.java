package com.sqli.gfi.dao;

import java.util.List;

import com.sqli.gfi.model.Statut;

public interface StatutDao {
	
	public List<Statut> getAllStatut();
	public Statut getStatutById(int idSt);

}
