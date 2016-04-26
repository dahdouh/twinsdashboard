package com.sqli.gfi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.sqli.gfi.model.Evenement;
import com.sqli.gfi.model.Utilisateur;

@Service
public class MailSenderServiceImpl implements MailSenderService {
	@Autowired
	private MailSender mailSender;

	@Override
	public void sendPassword(String email, String login, String password, Boolean active) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("sqli.gfi@gmail.com");
		message.setTo(email);
		message.setSubject("Nouveau compte");
		String etat = (active)?"activer":"désactiver";
		message.setText(
		"Bonjour Monsieur,\n\n" +
		"l'adminisrateur de Twins Outsourcing créer un compte pour vous:\n" +
		"login : " + login + "\n" +
		"password : " + password + "\n\n" +
		"l'etat de votre compte est : " + etat + "\n\n" +
		"merci \n\n "
		+ "Administrateur \n\n"
		+ "Cordialement");
		mailSender.send(message);
	}
	@Override
	public void reminderPassword(String email, String login, String password, Boolean active) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("sqli.gfi@gmail.com");
		message.setTo(email);
		message.setSubject("Nouveau mot de passe");
		String etat = (active)?"activer":"désactiver";
		message.setText(
		"Bonjour Monsieur,\n\n" +
		"l'adminisrateur de Twins Outsourcing vous attribuez un nouveau mot de passe:\n" +
		"login : " + login + "\n" +
		"password : " + password + "\n\n" +
		"l'etat de votre compte est : " + etat + "\n\n" +
		"merci \n\n "
		+ "Administrateur \n\n"
		+ "Cordialement");
		mailSender.send(message);
	}
	
	 
	public void sendUpdatePassword(String email, String login, String password, Boolean active) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("sqli.gfi@gmail.com");
		message.setTo(email);
		message.setSubject("Modification de Compte");
		String etat = (active)?"activer":"désactiver";
		message.setText(
		"Bonjour Monsieur,\n\n" +
		"la modification de votre comte à été bien éffectuée:\n" +
		"login : " + login + "\n" +
		"password : " + password + "\n\n" +
		"l'etat de votre compte est : " + etat + "\n\n" +
		"merci \n\n "
		+ "Administrateur \n\n"
		+ "Cordialement");
		mailSender.send(message);
	}

	 
	public void inscriptionConfirmation(String email, String resp_f, String formation) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("sqli.gfi@gmail.com");
		message.setTo(email);
		message.setSubject("Modification de Compte");
		message.setText(
		"Bonjour Monsieur,\n\n" +
		"Monsieur "+ resp_f +" vous inviter pour un nouveau evenement :"+ formation +"\n" +
		"merci \n\n "
		+ "Administrateur de GFI \n\n"
		+ "Cordialement");
		mailSender.send(message);
	}
	@Override
	public void sendInvitation(Utilisateur user, Evenement event) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("sqli.gfi@gmail.com");
		message.setTo(user.getEmail());
		message.setSubject("Invitation");
		message.setText(
		"Bonjour Mr/Mme "+ user.getPrenom()+" "+ user.getNom()+",\n\n" +
		"Twins Outsourcing vous invite à la réunion de  "+ event.getLibelle() +" qui aura lieu le:"+ event.getDate_evenement() +"\n" +
		"merci \n\n "
		+ "Cordialement \n\n"
		+ "Twins Outsourcing");
		mailSender.send(message);
	}
	
	@Override
	public void correspondance(Utilisateur user, String msg) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("twins.noreply@gmail.com");
		message.setTo(user.getEmail());
		message.setSubject("Correspondance du Client");
		message.setText(msg);
		mailSender.send(message);
	}
	
	

}
