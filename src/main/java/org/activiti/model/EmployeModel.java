package org.activiti.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.activiti.Employe;
import org.activiti.Priorite;

public class EmployeModel implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "matricule")
	private String matricule;
	
	private String nom;
	
	private String prenom;
	
	@ManyToOne
	@JoinColumn(name="manager")
	private Employe manager;

	@OneToMany(mappedBy = "owner")
	private List<Priorite> priorites;

	

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
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

	public Employe getManager() {
		return manager;
	}

	public void setManager(Employe manager) {
		this.manager = manager;
	}

	public List<Priorite> getPriorites() {
		return priorites;
	}

	public void setPriorites(List<Priorite> priorites) {
		this.priorites = priorites;
	}

}