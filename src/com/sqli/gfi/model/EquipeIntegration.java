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
@Table(name = "equipe_integration")
@PrimaryKeyJoinColumn(name = "id_equipe")
public class EquipeIntegration extends Equipe {
	
private static final long serialVersionUID = 5165L;
	
	public EquipeIntegration() {
    }

	public EquipeIntegration(String nom, Date date_creation, Set<Utilisateur> membres) {
	      super(nom, date_creation, membres);
	}


}
