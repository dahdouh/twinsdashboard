package com.sqli.gfi.service;

import java.util.List;
import com.sqli.gfi.model.Profil;

public interface ProfileService {

	public List<Profil> getAllProfils();

	public Profil getByProfilById(int idP);

	public void addProfil(Profil p);

	public void deleteProfil(int idP);

}
