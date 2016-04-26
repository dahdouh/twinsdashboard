package com.sqli.gfi.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;


/**
*
* @author karim
*/
@Entity
@Table(name = "evenement")
public class Evenement implements Serializable {
   
	
	private static final long serialVersionUID = 5165L;
	
	
   @Id
   @GeneratedValue (strategy=GenerationType.AUTO)
   @Column (name="id_evenement")
   private Integer id_evenement;
   
   @Column (name="libelle", length = 255)
   @NotEmpty(message="veuillez entrer la libelle")
   private String libelle;
   
   @Column (name="date_evenement")
   @DateTimeFormat(pattern="yyyy-MM-dd")
   private Date date_evenement;
   
   @Column (name="objectif", nullable = false)
   private String objectif;
   
   @ManyToMany(fetch = FetchType.EAGER)
   @JoinTable(name = "invitations", joinColumns = { 
				@JoinColumn(name = "id_evenement", nullable = false) }, 
				inverseJoinColumns = { @JoinColumn(name = "id_u", nullable = false) })
	private Set<Utilisateur> invitations = new HashSet<Utilisateur>(0);
   
   @ManyToOne(fetch = FetchType.EAGER)
   @JoinColumn (name="id_projet")
   private Projet projet;

   public Evenement() {
   }

	public Evenement(String libelle, Date date_evenement, String objectif,
			Set<Utilisateur> invitations) {
		super();
		this.libelle = libelle;
		this.date_evenement = date_evenement;
		this.objectif = objectif;
		this.invitations = invitations;
	}

	public Integer getId_evenement() {
		return id_evenement;
	}

	public void setId_evenement(Integer id_evenement) {
		this.id_evenement = id_evenement;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Date getDate_evenement() {
		return date_evenement;
	}

	public void setDate_evenement(Date date_evenement) {
		this.date_evenement = date_evenement;
	}

	public String getObjectif() {
		return objectif;
	}

	public void setObjectif(String objectif) {
		this.objectif = objectif;
	}

	public Set<Utilisateur> getInvitations() {
		return invitations;
	}

	public void setInvitations(Set<Utilisateur> invitations) {
		this.invitations = invitations;
	}

	public Projet getProjet() {
		return projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}

	@Override
	public String toString() {
		return "Evenement [libelle=" + libelle + ", date_evenement="
				+ date_evenement + ", objectif=" + objectif + "]";
	}	
   
}

