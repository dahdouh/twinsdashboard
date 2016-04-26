package com.sqli.gfi.dao;


import java.util.List;

import com.sqli.gfi.model.Profil;

public interface ProfileDao {

	public List<Profil> getAllProfils();

	public Profil getByProfilById(int idP);

	public void addProfil(Profil p);

	public void deleteProfil(int idP);
}
