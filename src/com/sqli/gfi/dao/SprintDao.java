package com.sqli.gfi.dao;

import java.util.List;

import com.sqli.gfi.model.Sprint;

public interface SprintDao {

	public List<Sprint> getAllSprint(int idP);

	public Sprint getSprintById(int idS);

	public void addSprint(Sprint sprint);

	public List<Sprint> getSprintsCompleted(int idP);

	public List<Sprint> getSprintsInprogress(int idP);

	public List<Sprint> getSprintsPending(int idP);
	
	public List<Sprint> getSprints(int idP);
	
}
