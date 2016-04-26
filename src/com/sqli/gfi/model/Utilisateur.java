/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sqli.gfi.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.sqli.gfi.model.Compte;
import com.sqli.gfi.model.Profil;

/**
 *
 * @author karim
 */
@Entity
@Table(name = "utilisateur")
@Inheritance(strategy = InheritanceType.JOINED)
public class Utilisateur implements Serializable {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 5165L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_u")
    private Integer id_u;
    
    @Column(name = "nom", length = 40, nullable = false)
    @NotEmpty(message="veuillez entrer votre nom")
    private String nom;

    @Column(name = "prenom", length = 40, nullable = false)
    @NotEmpty(message="veuillez entrer votre prenom")
    private String prenom;

    @Column(name = "adresse", length = 255, nullable = false)
    @NotEmpty(message="veuillez entrer votre adresse")
    private String adresse;

    @Column(name = "email", length = 100, nullable = false)
    @NotEmpty(message="veuillez entrer votre e-mail")
    @Email
    private String email;

    @Column(name = "tel", length = 50, nullable = false)
    @NotEmpty(message="veuillez entrer votre telephone")
    private String tel;
    
    @OneToOne(fetch = FetchType.EAGER, cascade={CascadeType.ALL}, orphanRemoval = true)
    @JoinColumn(name="id_compte", unique = true)
    private Compte compte;
    
    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE })
    @JoinColumn (name="id_profil")
    private Profil profil ;
    
    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE })
	@JoinColumn (name="id_equipe")
	private Equipe equipe;
    
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "invitations")
	private Set<Evenement> evenements = new HashSet<Evenement>(0);

    public Utilisateur() {
    }

	public Utilisateur(String nom, String prenom, String adresse, String email,
			String tel) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.email = email;
		this.tel = tel;
	}

	public Utilisateur(String nom, String prenom, String adresse, String email,
			String tel, Profil profil) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.email = email;
		this.tel = tel;
		this.profil = profil;
	}

	public Integer getId_u() {
		return id_u;
	}

	public void setId_u(Integer id_u) {
		this.id_u = id_u;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	public Profil getProfil() {
		return profil;
	}

	public void setProfil(Profil profil) {
		this.profil = profil;
	}

	public Equipe getEquipe() {
		return equipe;
	}

	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}

	public Set<Evenement> getEvenements() {
		return evenements;
	}

	public void setEvenements(Set<Evenement> evenements) {
		this.evenements = evenements;
	}

	@Override
	public String toString() {
		return "Utilisateur [id_u=" + id_u + ", nom=" + nom + ", prenom="
				+ prenom + ", adresse=" + adresse + ", email=" + email
				+ ", tel=" + tel + ", compte=" + compte + ", profil=" + profil
				+ ", equipe=" + equipe + ", evenements=" + evenements + "]";
	} 
      
}
