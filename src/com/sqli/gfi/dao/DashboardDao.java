package com.sqli.gfi.dao;

import java.util.List;

import com.sqli.gfi.model.DashboardManager;

public interface DashboardDao {
	
	public List<DashboardManager> getAllDashboardManager();
	public List<DashboardManager> getDashboardManagersByCritere(String criteria, String libelle);
	public void addDashboardManager(DashboardManager dashboardmanager);
	public DashboardManager getDashboardManagerById(int idD);
	public void deleteDashboardManager(int idD);
	public Long countDashboardManager();

}
