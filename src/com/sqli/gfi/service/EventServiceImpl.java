package com.sqli.gfi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sqli.gfi.dao.EventDao;
import com.sqli.gfi.model.Evenement;
import com.sqli.gfi.model.Projet;
import com.sqli.gfi.model.Utilisateur;

@Service
@Transactional
public class EventServiceImpl implements  EventService {
	@Autowired 
	private EventDao  eventDao;	
	
	@Override
	@Transactional(readOnly = true)
	public List<Evenement> getAllEvents() {
		return eventDao.getAllEvents();
	}

	@Override
	public void addEvent(Evenement event) {
		eventDao.addEvent(event);
	}

	@Override
	@Transactional(readOnly = true)
	public Evenement getEventById(int idE) {
		return eventDao.getEventById(idE);
	}

	@Override
	public void deleteEvent(int idE) {
		eventDao.deleteEvent(idE);
	}

	@Override
	@Transactional(readOnly = true)
	public Long countEvent() {
		return eventDao.countEvent();
	}
	
	@Override
	@Transactional(readOnly = true)
	public Long countTeamemberEvent(int idM) {
		return eventDao.countTeamemberEvent(idM);
	}

	@Override
	@Transactional(readOnly = true)
	public Projet getEventsByIdProject(int idP) {
		return eventDao.getEventsByIdProject(idP);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Evenement> getEventsByIdTeamMember(int idM) {
		return eventDao.getEventsByIdTeamMember(idM);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Utilisateur> getUserInvited(int idE) {
		return eventDao.getUserInvited(idE);
	}
}
