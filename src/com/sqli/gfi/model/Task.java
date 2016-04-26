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
@Table(name = "task")
public class Task implements Serializable {
   
	
	private static final long serialVersionUID = 5165L;
	
	
   @Id
   @GeneratedValue (strategy=GenerationType.AUTO)
   @Column (name="id_task")
   private Integer id_task;
   
   @Column (name="nom", length = 255)
   @NotEmpty(message="veuillez selectionner le nom de la tache")
   private String nom;
   
   @Column (name="priorite", nullable = false)
   @NotEmpty(message="veuillez entrer priorité de la tache")
   private String priorite;
   
   @Column (name="date_debut", nullable = true)
   @DateTimeFormat(pattern="yyyy-MM-dd")
   private Date date_debut;
   
   @Column (name="date_fin", nullable = true)
   @DateTimeFormat(pattern="yyyy-MM-dd")
   private Date date_fin;
   
   @Column (name="estimation", length = 255)
   @NotEmpty(message="veuillez entrer estimation de la tâche")
   private String estimation;
   
   @Column (name="date_debut_effective", nullable = true)
   @DateTimeFormat(pattern="yyyy-MM-dd")
   private Date date_debut_effective;
   
   @Column (name="date_fin_effective", nullable = true)
   @DateTimeFormat(pattern="yyyy-MM-dd")
   private Date date_fin_effective;
   
   
   @Column (name="[desc]", nullable = false)
   @NotEmpty(message="veuillez entrer la description de la tache ")
   private String desc;
   
   @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST,CascadeType.MERGE })
   @JoinColumn (name="id_sprint")
   private Sprint sprint;
   
   @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST,CascadeType.MERGE })
   @JoinColumn (name="id_responsable")
   @Valid
   private Utilisateur responsable;
   
   @ManyToOne(fetch = FetchType.EAGER)
   @JoinColumn (name="id_statut")
   private Statut statut;
   
   @OneToMany(mappedBy="task")
   private Set<Commentaire> comments = new HashSet<Commentaire>(0);
   
   @OneToMany(mappedBy="task")
   private Set<Attachement> attachements = new HashSet<Attachement>(0);
   
   
   

   public Task() {
   }
	
	public Task(String nom, String priorite, Date date_debut, Date date_fin,
		String desc, Sprint sprint, Utilisateur responsable, Statut statut,
		Set<Commentaire> comments, Set<Attachement> attachements) {
		super();
		this.nom = nom;
		this.priorite = priorite;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.desc = desc;
		this.sprint = sprint;
		this.responsable = responsable;
		this.statut = statut;
		this.comments = comments;
		this.attachements = attachements;
	}

	public Integer getId_task() {
		return id_task;
	}

	public void setId_task(Integer id_task) {
		this.id_task = id_task;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPriorite() {
		return priorite;
	}

	public void setPriorite(String priorite) {
		this.priorite = priorite;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Sprint getSprint() {
		return sprint;
	}

	public void setSprint(Sprint sprint) {
		this.sprint = sprint;
	}

	public Utilisateur getResponsable() {
		return responsable;
	}

	public void setResponsable(Utilisateur responsable) {
		this.responsable = responsable;
	}

	public Statut getStatut() {
		return statut;
	}

	public void setStatut(Statut statut) {
		this.statut = statut;
	}

	public Set<Commentaire> getComments() {
		return comments;
	}

	public void setComments(Set<Commentaire> comments) {
		this.comments = comments;
	}

	public Set<Attachement> getAttachements() {
		return attachements;
	}

	public void setAttachements(Set<Attachement> attachements) {
		this.attachements = attachements;
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

	public String getEstimation() {
		return estimation;
	}

	public void setEstimation(String estimation) {
		this.estimation = estimation;
	}

	public Date getDate_debut_effective() {
		return date_debut_effective;
	}

	public void setDate_debut_effective(Date date_debut_effective) {
		this.date_debut_effective = date_debut_effective;
	}

	public Date getDate_fin_effective() {
		return date_fin_effective;
	}

	public void setDate_fin_effective(Date date_fin_effective) {
		this.date_fin_effective = date_fin_effective;
	}

	@Override
	public String toString() {
		return "Task [id_task=" + id_task + ", nom=" + nom + ", priorite="
				+ priorite + ", date_debut=" + date_debut + ", date_fin="
				+ date_fin + ", desc=" + desc + ", statut=" + statut + "]";
	}

  
}

