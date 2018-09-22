package org.activiti;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Employe implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "matricule")
	private String matricule;
	
	private String nom;
	
	private String prenom;
	
	private Employe manager;

	@OneToMany(mappedBy = "owner")
	private List<Priorite> priorites;

	public Employe() {
		super();
	}

	public Employe(String matricule, String nom, String prenom,
			Employe manager, List<Priorite> priorites) {
		super();
		this.matricule = matricule;
		this.nom = nom;
		this.prenom = prenom;
		this.manager = manager;
		this.priorites = priorites;
	}

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
