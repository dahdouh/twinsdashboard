package com.sqli.gfi.dao;

import java.util.List;

import com.sqli.gfi.model.FicheClient;

public interface FicheClientDao {

	public List<FicheClient> getAllFicheClient();
	public void addFicheclient(FicheClient ficheclient);
	public FicheClient getFicheclientById(int idF);
	public void deleteFicheclient(int idF);
	public Long countFicheclient();
}
