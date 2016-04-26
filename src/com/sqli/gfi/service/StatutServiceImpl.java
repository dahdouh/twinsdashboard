package com.sqli.gfi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sqli.gfi.dao.StatutDao;
import com.sqli.gfi.model.Statut;

@Service
@Transactional
public class StatutServiceImpl implements StatutService {

	@Autowired
	private StatutDao statutDao;

	@Override
	@Transactional(readOnly = true)
	public List<Statut> getAllStatut() {
		return statutDao.getAllStatut();
	}

	@Override
	@Transactional(readOnly = true)
	public Statut getStatutById(int idSt) {
		return statutDao.getStatutById(idSt);
	}
}
