package com.sqli.gfi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sqli.gfi.dao.FicheClientDao;
import com.sqli.gfi.model.FicheClient;

@Service
@Transactional
public class FicheClientServiceImpl implements FicheClientService{

	@Autowired
	private FicheClientDao ficheClientDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<FicheClient> getAllFicheClient() {
		return ficheClientDao.getAllFicheClient();
	}

	@Override
	public void addFicheclient(FicheClient ficheclient) {
		ficheClientDao.addFicheclient(ficheclient);
		
	}

	@Override
	@Transactional(readOnly = true)
	public FicheClient getFicheclientById(int idF) {
		return ficheClientDao.getFicheclientById(idF);
	}

	@Override
	public void deleteFicheclient(int idF) {
		ficheClientDao.deleteFicheclient(idF);
	}

	@Override
	public Long countFicheclient() {
		return ficheClientDao.countFicheclient();
	}

}
