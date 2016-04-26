/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sqli.gfi.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author karim
 */
@Entity
@Table(name="dashboard_manager")
@PrimaryKeyJoinColumn(name = "id_u")
public class DashboardManager extends Utilisateur {

	private static final long serialVersionUID = 5165L;

	public DashboardManager() {
    }

    public DashboardManager(String nom, String prenom, String adresse, String email, String tel) {
        super(nom, prenom, adresse, email, tel);
    }
    
    
    
}
