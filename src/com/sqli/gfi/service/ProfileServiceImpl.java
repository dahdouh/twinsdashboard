package com.sqli.gfi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sqli.gfi.dao.ProfileDao;
import com.sqli.gfi.model.Profil;

@Service
@Transactional
public class ProfileServiceImpl implements ProfileService {
	@Autowired 
	private ProfileDao profileDao;

	 
	public List<Profil> getAllProfils() {
		return profileDao.getAllProfils();
	}

	 
	public Profil getByProfilById(int idP) {
		return profileDao.getByProfilById(idP);
	}

	 
	public void addProfil(Profil p) {
		profileDao.addProfil(p);
	}

	 
	public void deleteProfil(int idP) {
		profileDao.deleteProfil(idP);
		
	}
	

}
