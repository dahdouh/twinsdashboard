package com.sqli.gfi.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
*
* @author karim
*/
@Entity
@Table(name = "equipe_developpement")
@PrimaryKeyJoinColumn(name = "id_equipe")
public class EquipeDeveloppement extends Equipe  {
	
	private static final long serialVersionUID = 5165L;
	
	public EquipeDeveloppement() {
    }

	public EquipeDeveloppement(String nom, Date date_creation, Set<Utilisateur> membres) {
	      super(nom, date_creation, membres);
	}

}
