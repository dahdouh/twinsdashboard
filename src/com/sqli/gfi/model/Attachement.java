package com.sqli.gfi.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

/**
*
* @author karim
*/
@Entity
@Table(name = "attachement")
public class Attachement implements Serializable {
   
	
	private static final long serialVersionUID = 5165L;
	
	
	   @Id
	   @GeneratedValue (strategy=GenerationType.AUTO)
	   @Column (name="id_attachement")
	   private Integer id_attachement;
	   
	   @Column (name="nom", length = 255)
	   @NotEmpty(message="veuillez entrer le nom de document")
	   private String nom;
	   
	   @Column (name="url", nullable = false)
	   private String url;
	   
	   @Column(name="contenu")
	   private  byte[] contenu;
	   
	   @Column(name="filename")
	   private String filename;
	   
	   @Column(name="TypeContenu")
	   private String TypeContenu;
	   
	   @Column(name="date_attachement", nullable = true)
	   @DateTimeFormat(pattern="yyyy-MM-dd")
	   private Date date_attachement;
	   
	   @ManyToOne(fetch = FetchType.EAGER)
	   @JoinColumn (name="id_sprint")
	   private Sprint sprint;
	   
	   @ManyToOne(fetch = FetchType.EAGER)
	   @JoinColumn (name="id_task")
	   private Task task;
	
	   public Attachement() {
	   }

		public Attachement(String nom, String url, byte[] contenu, String filename,
			String typeContenu, Date date_attachement, Sprint sprint, Task task) {
			super();
			this.nom = nom;
			this.url = url;
			this.contenu = contenu;
			this.filename = filename;
			TypeContenu = typeContenu;
			this.date_attachement = date_attachement;
			this.sprint = sprint;
			this.task = task;
		}





		public Integer getId_attachement() {
			return id_attachement;
		}

		public void setId_attachement(Integer id_attachement) {
			this.id_attachement = id_attachement;
		}

		public String getNom() {
			return nom;
		}

		public void setNom(String nom) {
			this.nom = nom;
		}

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		public byte[] getContenu() {
			return contenu;
		}

		public void setContenu(byte[] contenu) {
			this.contenu = contenu;
		}

		public String getTypeContenu() {
			return TypeContenu;
		}

		public void setTypeContenu(String typeContenu) {
			TypeContenu = typeContenu;
		}

		public Date getDate_attachement() {
			return date_attachement;
		}

		public void setDate_attachement(Date date_attachement) {
			this.date_attachement = date_attachement;
		}

		public Sprint getSprint() {
			return sprint;
		}

		public void setSprint(Sprint sprint) {
			this.sprint = sprint;
		}

		public Task getTask() {
			return task;
		}

		public void setTask(Task task) {
			this.task = task;
		}

		public String getFilename() {
			return filename;
		}

		public void setFilename(String filename) {
			this.filename = filename;
		}

		@Override
		public String toString() {
			return "Attachement [nom=" + nom + ", url=" + url + ", contenu="
					+ Arrays.toString(contenu) + ", filename=" + filename
					+ ", TypeContenu=" + TypeContenu + ", date_attachement="
					+ date_attachement + "]";
		} 
	
}

