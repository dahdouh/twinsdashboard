package com.sqli.gfi.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

/**
*
* @author karim
*/
@Entity
@Table(name = "statut")
public class Statut implements Serializable {
   
	
   private static final long serialVersionUID = 5165L;
	
   @Id
   @GeneratedValue (strategy=GenerationType.AUTO)
   @Column (name="id_statut")
   private Integer id_statut;
   
   @Column (name="libelle", length = 255)
   @NotEmpty(message="veuillez selectionner un statut")
   private String libelle;
   
   @Column (name="[desc]", nullable = false)
   @NotEmpty(message="veuillez entrer une description")
   private String desc;
   
   @OneToMany(mappedBy="statut")
   private Set<Sprint> sprints = new HashSet<Sprint>(0);

   @OneToMany(mappedBy="statut")
   private Set<Task> tasks = new HashSet<Task>(0);
   

   public Statut() {
   }

	public Statut(String libelle, String desc, Set<Task> tasks) {
		super();
		this.libelle = libelle;
		this.desc = desc;
		this.tasks = tasks;
	}

	public Integer getId_statut() {
		return id_statut;
	}

	public void setId_statut(Integer id_statut) {
		this.id_statut = id_statut;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Set<Task> getTasks() {
		return tasks;
	}

	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}

	public Set<Sprint> getSprints() {
		return sprints;
	}

	public void setSprints(Set<Sprint> sprints) {
		this.sprints = sprints;
	}

	@Override
	public String toString() {
		return "Statut [id_statut=" + id_statut + ", libelle=" + libelle
				+ ", desc=" + desc + "]";
	}

   
}

