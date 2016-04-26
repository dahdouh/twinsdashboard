package com.sqli.gfi.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;
/**
*
* @author karim
*/
@Entity
@Table(name = "fiche_client")
public class FicheClient implements Serializable {
   
	
	private static final long serialVersionUID = 5165L;
	
	
   @Id
   @GeneratedValue (strategy=GenerationType.AUTO)
   @Column (name="id_ficheClient")
   private Integer id_ficheClient;
   
   @Column (name="nomContact", nullable = false)
   @NotEmpty(message="veuillez entrer le nom ")
   private String nomContact;

   @Column (name="prenomContact", nullable = false)
   @NotEmpty(message="veuillez entrer le prenom ")
   private String prenomContact;
   
   @Column (name="emailContact", nullable = false)
   @NotEmpty(message="veuillez entrer email ")
   private String emailContact;
   
   @Column (name="telephone_1", nullable = false)
   @NotEmpty(message="veuillez entrer telephone ")
   private String telephone_1;
   
   @Column (name="telephone_2", nullable = false)
   private String telephone_2;
   
   @Column (name="adresse", nullable = false)
   @NotEmpty(message="veuillez entrer une adresse ")
   private String adresse;
   
   @Column (name="siteweb", nullable = false)
   private String siteweb;
   
//   @OneToOne(fetch = FetchType.EAGER)
//   @JoinColumn(name="id_client", unique = true)
//   private Client client;
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST,CascadeType.MERGE })
	@JoinColumn (name="id_client")
	private Client client;
      
   @OneToOne(mappedBy="ficheClient")
   private Projet projet;
   

   public FicheClient() {
   }
   
	public FicheClient(String nomContact, String prenomContact,
		String emailContact, String telephone_1, String telephone_2,
		String adresse, String siteweb, Client client, Projet projet) {
		super();
		this.nomContact = nomContact;
		this.prenomContact = prenomContact;
		this.emailContact = emailContact;
		this.telephone_1 = telephone_1;
		this.telephone_2 = telephone_2;
		this.adresse = adresse;
		this.siteweb = siteweb;
		this.client = client;
		this.projet = projet;
	}





	public Integer getId_ficheClient() {
		return id_ficheClient;
	}
	
	
	public void setId_ficheClient(Integer id_ficheClient) {
		this.id_ficheClient = id_ficheClient;
	}
	
	
	public String getNomContact() {
		return nomContact;
	}
	
	
	public void setNomContact(String nomContact) {
		this.nomContact = nomContact;
	}
	
	
	public String getPrenomContact() {
		return prenomContact;
	}
	
	
	public void setPrenomContact(String prenomContact) {
		this.prenomContact = prenomContact;
	}
	
	public String getEmailContact() {
		return emailContact;
	}

	public void setEmailContact(String emailContact) {
		this.emailContact = emailContact;
	}

	public String getTelephone_1() {
		return telephone_1;
	}
	
	
	public void setTelephone_1(String telephone_1) {
		this.telephone_1 = telephone_1;
	}
	
	
	public String getTelephone_2() {
		return telephone_2;
	}
	
	
	public void setTelephone_2(String telephone_2) {
		this.telephone_2 = telephone_2;
	}
	
	
	public String getAdresse() {
		return adresse;
	}
	
	
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Projet getProjet() {
		return projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}

	public String getSiteweb() {
		return siteweb;
	}

	public void setSiteweb(String siteweb) {
		this.siteweb = siteweb;
	}

	@Override
	public String toString() {
		return "FicheClient [nomContact=" + nomContact + ", prenomContact="
				+ prenomContact + ", emailContact=" + emailContact
				+ ", telephone_1=" + telephone_1 + ", telephone_2="
				+ telephone_2 + ", adresse=" + adresse + ", siteweb=" + siteweb
				+ "]";
	}
	
  
}
