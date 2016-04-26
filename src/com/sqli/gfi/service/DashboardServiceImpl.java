package com.sqli.gfi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sqli.gfi.dao.DashboardDao;
import com.sqli.gfi.model.DashboardManager;

@Service
@Transactional
public class DashboardServiceImpl implements DashboardService {

	 @Autowired 
	 private DashboardDao dashboardDao;	    
	 
	@Override
	@Transactional(readOnly = true)
	public List<DashboardManager> getAllDashboardManager() {
		return dashboardDao.getAllDashboardManager();
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<DashboardManager> getDashboardManagersByCritere(String criteria, String libelle) {
		return dashboardDao.getDashboardManagersByCritere(criteria, libelle);
	}
	
	@Override
	@Transactional(readOnly = true)
	public DashboardManager getDashboardManagerById(int idD) {
		return dashboardDao.getDashboardManagerById(idD);
	}
	
	@Override
	public void addDashboardManager(DashboardManager dashboardmanager) {
		dashboardDao.addDashboardManager(dashboardmanager);
	}
	
	@Override
	public void deleteDashboardManager(int idD) {
		dashboardDao.deleteDashboardManager(idD);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Long countDashboardManager() {
		return dashboardDao.countDashboardManager();
	}

}
