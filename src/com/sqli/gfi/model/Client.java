/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sqli.gfi.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author karim
 */
@Entity
@Table(name = "client")
@PrimaryKeyJoinColumn(name = "id_u")
public class Client extends Utilisateur{
	
	private static final long serialVersionUID = 5165L;
	
	private String societe;

//	@OneToOne(mappedBy="client")
//	private FicheClient ficheclient;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "client")
	private Set<FicheClient> fichesclient = new HashSet<FicheClient>(0);
	
    public Client() {
    	 super();
    }

    public Client(String nom, String prenom, String adresse, String email, String tel, String societe) {
        super(nom, prenom, adresse, email, tel);
        this.societe =societe;
    }

	public Client(String societe, Set<FicheClient> fichesclient) {
		super();
		this.societe = societe;
		this.fichesclient = fichesclient;
	}

	public String getSociete() {
		return societe;
	}

	public void setSociete(String societe) {
		this.societe = societe;
	}
	

	public Set<FicheClient> getFichesclient() {
		return fichesclient;
	}

	public void setFichesclient(Set<FicheClient> fichesclient) {
		this.fichesclient = fichesclient;
	}

	

	
        
}
