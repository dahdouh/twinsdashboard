package com.sqli.gfi.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

/**
*
* @author karim
*/
@Entity
@Table(name = "sprint")
public class Sprint implements Serializable {
   
	
	private static final long serialVersionUID = 5165L;
	
	
   @Id
   @GeneratedValue (strategy=GenerationType.AUTO)
   @Column (name="id_sprint")
   private Integer id_sprint;
   
   @Column (name="nom", length = 255)
   @NotEmpty(message="veuillez selectionner le nom du spring")
   private String nom;
   
   @Column (name="date_debut", nullable = true)
   @DateTimeFormat(pattern="yyyy-MM-dd")
   private Date date_debut;
   
   @Column (name="date_fin", nullable = true)
   @DateTimeFormat(pattern="yyyy-MM-dd")
   private Date date_fin;
   
   @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST,CascadeType.MERGE })
   @JoinColumn (name="id_statut")
   private Statut statut ;
   
   @ManyToOne(fetch = FetchType.EAGER)
   @JoinColumn (name="id_projet")
   @Valid
   private Projet projet;
   
   @OneToMany(fetch = FetchType.EAGER, mappedBy="sprint")
   private Set<Task> tasks = new HashSet<Task>(0);
   
   @OneToMany(fetch = FetchType.EAGER, mappedBy="sprint")
   private Set<Attachement> attachements = new HashSet<Attachement>(0);

   public Sprint() {
   }

	public Sprint(String nom, Date date_debut, Date date_fin, Projet projet,
			Set<Task> tasks, Set<Attachement> attachements) {
		super();
		this.nom = nom;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.projet = projet;
		this.tasks = tasks;
		this.attachements = attachements;
	}

	public Integer getId_sprint() {
		return id_sprint;
	}

	public void setId_sprint(Integer id_sprint) {
		this.id_sprint = id_sprint;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Date getDate_debut() {
		return date_debut;
	}

	public void setDate_debut(Date date_debut) {
		this.date_debut = date_debut;
	}

	public Date getDate_fin() {
		return date_fin;
	}

	public void setDate_fin(Date date_fin) {
		this.date_fin = date_fin;
	}

	public Projet getProjet() {
		return projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}

	public Set<Task> getTasks() {
		return tasks;
	}

	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}

	public Set<Attachement> getAttachements() {
		return attachements;
	}

	public void setAttachements(Set<Attachement> attachements) {
		this.attachements = attachements;
	}

	public Statut getStatut() {
		return statut;
	}

	public void setStatut(Statut statut) {
		this.statut = statut;
	}

	@Override
	public String toString() {
		return "Sprint [id_sprint=" + id_sprint + ", nom=" + nom
				+ ", date_debut=" + date_debut + ", date_fin=" + date_fin
				+ ", projet=" + projet + ", tasks=" + tasks + ", attachements="
				+ attachements + "]";
	}	  
   
   
}
