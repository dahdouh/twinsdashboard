package com.sqli.gfi.service;

import java.util.List;

import com.sqli.gfi.model.DashboardManager;

/**
*
* @author karim
* 
*/
public interface DashboardService {
	
	public List<DashboardManager> getAllDashboardManager();
	public List<DashboardManager> getDashboardManagersByCritere(String criteria, String libelle);
	public void addDashboardManager(DashboardManager dashboardmanager);
	public DashboardManager getDashboardManagerById(int idD);
	public void deleteDashboardManager(int idD);
	public Long countDashboardManager();

	
}
