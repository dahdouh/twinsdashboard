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
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "equipe")
@Inheritance(strategy = InheritanceType.JOINED)
public class Equipe implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5165L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_equipe")
    private Integer id_equipe;
    
	@Column(name = "nom", length = 100, nullable = false)
    @NotEmpty(message="veuillez entrer votre nom")
    private String nom;
	
	@Column(name = "date_creation", nullable = true)
	@DateTimeFormat(pattern="yyyy-MM-dd")
    private Date date_creation;
	
	@Column (name="[desc]", nullable = false)
	@NotEmpty(message="veuillez entrer la description de la tache ")
	private String desc;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "equipe")
	private Set<Utilisateur> membres = new HashSet<Utilisateur>(0);
	 
	
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "equipes")
	private Set<Projet> projets = new HashSet<Projet>(0);
	
	public Equipe() {
		super();
	}

	public Equipe(String nom, Date date_creation, Set<Utilisateur> membres) {
		super();
		this.nom = nom;
		this.date_creation = date_creation;
		this.membres = membres;
	}

	public Equipe(String nom, Date date_creation, Set<Utilisateur> membres,
			Set<Projet> projets) {
		super();
		this.nom = nom;
		this.date_creation = date_creation;
		this.membres = membres;
		this.projets = projets;
	}

	public Integer getId_equipe() {
		return id_equipe;
	}

	public void setId_equipe(Integer id_equipe) {
		this.id_equipe = id_equipe;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Date getDate_creation() {
		return date_creation;
	}

	public void setDate_creation(Date date_creation) {
		this.date_creation = date_creation;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Set<Utilisateur> getMembres() {
		return membres;
	}

	public void setMembres(Set<Utilisateur> membres) {
		this.membres = membres;
	}

	public Set<Projet> getProjets() {
		return projets;
	}

	public void setProjets(Set<Projet> projets) {
		this.projets = projets;
	}

	@Override
	public String toString() {
		return "Equipe [id_equipe=" + id_equipe + ", nom=" + nom
				+ ", date_creation=" + date_creation + ", desc=" + desc + "]";
	}

	

	
	
}
