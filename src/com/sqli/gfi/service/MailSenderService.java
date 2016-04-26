package com.sqli.gfi.service;

import com.sqli.gfi.model.Evenement;
import com.sqli.gfi.model.Utilisateur;

public interface MailSenderService {

	public void sendPassword(String email, String login, String password, Boolean active);
	public void reminderPassword(String email, String login, String password, Boolean active);
	public void sendUpdatePassword(String email, String login, String password, Boolean active);
	public void inscriptionConfirmation(String email, String resp_f, String formation);
	public void sendInvitation(Utilisateur user, Evenement event);
	public void correspondance(Utilisateur client, String msg);
	
}
