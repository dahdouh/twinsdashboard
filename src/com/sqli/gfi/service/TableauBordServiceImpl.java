package com.sqli.gfi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sqli.gfi.dao.TableauBordDao;


@Service
@Transactional
public class TableauBordServiceImpl implements TableauBordService {

	@Autowired
	private TableauBordDao tableauBordDao;
	
	 
	@Transactional(readOnly = true)
	public Long countCollaborateurBySession(int idS) {
		return tableauBordDao.countCollaborateurBySession(idS);
	}

	 
	@Transactional(readOnly = true)
	public Long countAbsenceBySession(int idS) {
		return tableauBordDao.countAbsenceBySession(idS);
	}
	
	
	
}
