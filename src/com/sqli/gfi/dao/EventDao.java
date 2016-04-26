package com.sqli.gfi.dao;

import java.util.List;

import com.sqli.gfi.model.Evenement;
import com.sqli.gfi.model.Projet;
import com.sqli.gfi.model.Utilisateur;

public interface EventDao {

	public List<Evenement> getAllEvents();

	public void addEvent(Evenement event);

	public Evenement getEventById(int idE);

	public void deleteEvent(int idE);

	public Long countEvent();
	
	public Long countTeamemberEvent(int idM);
	
	//___________________ Project event ___________________//
	//____________________________________________________//
	
	public Projet getEventsByIdProject(int idP);
	
	public List<Evenement> getEventsByIdTeamMember(int idM);
	
	public List<Utilisateur> getUserInvited(int idE);
}
