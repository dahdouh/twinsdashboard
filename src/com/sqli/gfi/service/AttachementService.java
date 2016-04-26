package com.sqli.gfi.service;

import java.util.List;

import com.sqli.gfi.model.Attachement;

public interface AttachementService {

	public List<Attachement> getFilesByIdSprint(int idS);
	
	public List<Attachement> getFilesByIdTask(int idT);

	public List<Attachement> getFilesByIdProject(int idP);

	public Attachement getAttachementById(int idA);

	public void addAttechement(Attachement file);

	public void deleteAttachment(int idA);

}
