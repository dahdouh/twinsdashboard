package com.sqli.gfi.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "equipe_design")
@PrimaryKeyJoinColumn(name = "id_equipe")
public class EquipeDesign  extends Equipe{
	
	private static final long serialVersionUID = 5165L;
	
	public EquipeDesign() {
    }

	public EquipeDesign(String nom, Date date_creation, Set<Utilisateur> membres) {
	      super(nom, date_creation, membres);
	}

}
