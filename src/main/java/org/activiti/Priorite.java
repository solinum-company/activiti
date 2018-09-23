package org.activiti;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Priorite {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String titre;
	private String description;
	@Temporal(TemporalType.DATE)
	private Date dateFin;

	@ManyToOne
	@JoinColumn(name = "owner")
	private Employe owner;

	public Priorite() {
		super();
	}

	public Priorite(Long id, String titre, String description, Date dateFin,
			Employe owner) {
		super();
		this.id = id;
		this.titre = titre;
		this.description = description;
		this.dateFin = dateFin;
		this.owner = owner;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public Employe getOwner() {
		return owner;
	}

	public void setOwner(Employe owner) {
		this.owner = owner;
	}

}
