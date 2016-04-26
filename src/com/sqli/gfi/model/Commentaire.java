package com.sqli.gfi.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.Valid;

import org.hibernate.validator.constraints.NotEmpty;

/**
*
* @author karim
*/
@Entity
@Table(name = "commentaire")
public class Commentaire implements Serializable {
   
	
	private static final long serialVersionUID = 5165L;
	
	
   @Id
   @GeneratedValue (strategy=GenerationType.AUTO)
   @Column (name="id_comment")
   private Integer id_comment;
   
   @Column (name="contenu", length = 255)
   @NotEmpty(message="veuillez selectionner le contenu du commentaire")
   private String contenu;
   
   @Column (name="date_comment", nullable = false)
   @NotEmpty(message="veuillez entrer la date du commentaire ")
   private Date date_comment;
   
   @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST,CascadeType.MERGE })
   @JoinColumn (name="id_task")
   @Valid
   private Task task;
   
   @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST,CascadeType.MERGE })
   @JoinColumn (name="id_u")
   @Valid
   private Utilisateur utilisateur;

   public Commentaire() {
   }

	public Commentaire(String contenu, Date date_comment, Task task,
			Utilisateur utilisateur) {
		super();
		this.contenu = contenu;
		this.date_comment = date_comment;
		this.task = task;
		this.utilisateur = utilisateur;
	}

	public Integer getId_comment() {
		return id_comment;
	}

	public void setId_comment(Integer id_comment) {
		this.id_comment = id_comment;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public Date getDate_comment() {
		return date_comment;
	}

	public void setDate_comment(Date date_comment) {
		this.date_comment = date_comment;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	@Override
	public String toString() {
		return "Commentaire [id_comment=" + id_comment + ", contenu=" + contenu
				+ ", date_comment=" + date_comment + ", task=" + task
				+ ", utilisateur=" + utilisateur + "]";
	}
	
	
}

