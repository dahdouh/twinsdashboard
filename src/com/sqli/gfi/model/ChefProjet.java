/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sqli.gfi.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author karim
 */
@Entity
@Table(name = "chef_projet")
@PrimaryKeyJoinColumn(name = "id_u")
public class ChefProjet extends Utilisateur{
	
	private static final long serialVersionUID = 5165L;
	
	@OneToMany(mappedBy="chefprojet")
    private Set<Projet> projets = new HashSet<Projet>(0);

    public ChefProjet() {
    }

    public ChefProjet(String nom, String prenom, String adresse, String email, String tel) {
        super(nom, prenom, adresse, email, tel);
    }

	public ChefProjet(String nom, String prenom, String adresse,
			String email, String tel, Profil profil) {
		super(nom, prenom, adresse, email, tel, profil);
		// TODO Auto-generated constructor stub
	}

	public Set<Projet> getProjets() {
		return projets;
	}

	public void setProjets(Set<Projet> projets) {
		this.projets = projets;
	}    
    
}
