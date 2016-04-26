package com.sqli.gfi.service;

import java.util.List;

import com.sqli.gfi.model.Statut;

public interface StatutService {
	
	public List<Statut> getAllStatut();
	public Statut getStatutById(int idSt);

}
