package com.sqli.gfi.service;

import java.util.List;

import com.sqli.gfi.model.Task;

public interface TaskService {

	public List<Task> getTasksByIdSprint(int idS);

	public List<Task> getTasksByIdProject(int idP);

	public void addTask(Task task);

	public Task getTaskById(int idT);

	public void deleteTask(int idT);

	public List<Task> getTasksCompleted(int idS);

	public List<Task> getTasksInprogress(int idS);

	public List<Task> getTasksPending(int idS);

	public List<Task> getTasksByIdTeamMember(int idM);
	
	public long countTeamemberMyTask(int idM);

}
