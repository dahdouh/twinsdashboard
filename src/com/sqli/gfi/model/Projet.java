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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "projet")
public class Projet implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5165L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_projet")
    private Integer id_projet;
    
	@Column(name = "nom", length = 100, nullable = false)
    @NotEmpty(message="veuillez entrer le nom du projet")
    private String nom;
	
	@Column(name = "date_creation", length = 100, nullable = true)
	@DateTimeFormat(pattern="yyyy-MM-dd")
    private Date date_creation;
	
	@Column(name = "[desc]", length = 100, nullable = false)
    private String desc;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "projet_equipe", joinColumns = { 
				@JoinColumn(name = "id_projet", nullable = false) }, 
				inverseJoinColumns = { @JoinColumn(name = "id_equipe", nullable = false) })
	private Set<Equipe> equipes = new HashSet<Equipe>(0);
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy="projet")
	private Set<Sprint> sprints = new HashSet<Sprint>(0);
	
//	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	@JoinTable(name = "projet_client", joinColumns = { 
//				@JoinColumn(name = "id_projet", nullable = false) }, 
//				inverseJoinColumns = { @JoinColumn(name = "id_equipe", nullable = false) })
//	private Set<Client> clients = new HashSet<Client>(0);
	
	
	@OneToOne(fetch = FetchType.EAGER, cascade={CascadeType.ALL})
    @JoinColumn(name="id_ficheclient", unique = true)
	private FicheClient ficheClient;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST,CascadeType.MERGE })
    @JoinColumn (name="id_chefprojet")
    private ChefProjet chefprojet ;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy="projet")
	private Set<Evenement> evenements = new HashSet<Evenement>(0);
	
	

	public Set<Evenement> getEvenements() {
		return evenements;
	}

	public void setEvenements(Set<Evenement> evenements) {
		this.evenements = evenements;
	}

	public Projet() {
		super();
	}

	public Projet(String nom, Date date_creation, String desc,
			Set<Equipe> equipes, Set<Sprint> sprints, FicheClient ficheClient,
			ChefProjet chefprojet) {
		super();
		this.nom = nom;
		this.date_creation = date_creation;
		this.desc = desc;
		this.equipes = equipes;
		this.sprints = sprints;
		this.ficheClient = ficheClient;
		this.chefprojet = chefprojet;
	}





	public Integer getId_projet() {
		return id_projet;
	}

	public void setId_projet(Integer id_projet) {
		this.id_projet = id_projet;
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

	public Set<Equipe> getEquipes() {
		return equipes;
	}

	public void setEquipes(Set<Equipe> equipes) {
		this.equipes = equipes;
	}

	public Set<Sprint> getSprints() {
		return sprints;
	}

	public void setSprints(Set<Sprint> sprints) {
		this.sprints = sprints;
	}


	public ChefProjet getChefprojet() {
		return chefprojet;
	}

	public void setChefprojet(ChefProjet chefprojet) {
		this.chefprojet = chefprojet;
	}

	public FicheClient getFicheClient() {
		return ficheClient;
	}

	public void setFicheClient(FicheClient ficheClient) {
		this.ficheClient = ficheClient;
	}

	@Override
	public String toString() {
		return "Projet [id_projet=" + id_projet + ", nom=" + nom
				+ ", date_creation=" + date_creation + ", desc=" + desc + "]";
	}

	


}
