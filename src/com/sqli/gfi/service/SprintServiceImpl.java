package com.sqli.gfi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sqli.gfi.dao.SprintDao;
import com.sqli.gfi.model.Sprint;

@Service
@Transactional
public class SprintServiceImpl implements SprintService {

	@Autowired 
    private SprintDao sprintDao;

	@Override
	@Transactional(readOnly = true)
	public List<Sprint> getAllSprint(int idP) {
		return sprintDao.getAllSprint(idP);
	}

	@Override
	public void addSprint(Sprint sprint) {
		sprintDao.addSprint(sprint);
	}

	@Override
	@Transactional(readOnly = true)
	public Sprint getSprintById(int idS) {
		return sprintDao.getSprintById(idS);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Sprint> getSprintsCompleted(int idP) {
		return sprintDao.getSprintsCompleted(idP);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Sprint> getSprintsInprogress(int idP) {
		return sprintDao.getSprintsInprogress(idP);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Sprint> getSprintsPending(int idP) {
		return sprintDao.getSprintsPending(idP);
	}

	@Override
	public List<Sprint> getSprints(int idP) {
		 return sprintDao.getSprints(idP);
	}
}
