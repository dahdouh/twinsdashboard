package com.sqli.gfi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sqli.gfi.dao.AttachementDao;
import com.sqli.gfi.model.Attachement;

@Service
@Transactional
public class AttachementServiceImpl implements AttachementService{

	@Autowired 
    private AttachementDao attachementDao;

	@Override
	@Transactional(readOnly = true)
	public List<Attachement> getFilesByIdSprint(int idS) {
		return attachementDao.getFilesByIdSprint(idS);
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Attachement> getFilesByIdTask(int idT) {
		return attachementDao.getFilesByIdTask(idT);
	}

	@Override
	@Transactional(readOnly = true)
	public Attachement getAttachementById(int idA) {
		return attachementDao.getAttachementById(idA);
	}

	@Override
	public void addAttechement(Attachement file) {
		attachementDao.addAttechement(file);
	}

	@Override
	public void deleteAttachment(int idA) {
		attachementDao.deleteAttachment(idA);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Attachement> getFilesByIdProject(int idP) {
		return attachementDao.getFilesByIdProject(idP);
	}

}
