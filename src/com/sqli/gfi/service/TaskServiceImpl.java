package com.sqli.gfi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sqli.gfi.dao.TaskDao;
import com.sqli.gfi.model.Task;

@Service
@Transactional
public class TaskServiceImpl implements TaskService {

	@Autowired
	private TaskDao taskDao;

	@Override
	@Transactional(readOnly = true)
	public List<Task> getTasksByIdSprint(int idS) {
		return taskDao.getTasksByIdSprint(idS);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Task> getTasksByIdProject(int idP) {
		return taskDao.getTasksByIdProject(idP);
	}
	
	@Override
	@Transactional(readOnly = true)
	public void addTask(Task task) {
		taskDao.addTask(task);
	}

	@Override
	@Transactional(readOnly = true)
	public Task getTaskById(int idT) {
		return taskDao.getTaskById(idT);
	}

	@Override
	public void deleteTask(int idT) {
		taskDao.deleteTask(idT);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Task> getTasksCompleted(int idS) {
		return taskDao.getTasksCompleted(idS);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Task> getTasksInprogress(int idS) {
		return taskDao.getTasksInprogress(idS);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Task> getTasksPending(int idS) {
		return taskDao.getTasksPending(idS);
	}

	@Override
	public List<Task> getTasksByIdTeamMember(int idM) {
		return taskDao.getTasksByIdTeamMember(idM);
	}

	@Override
	public long countTeamemberMyTask(int idM) {
		return taskDao.countTeamemberMyTask(idM);
	}

}
