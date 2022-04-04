package com.ycaocc.model;

public class Stage {
	private int id;
	private String entreprise;
	private String emploi;
	private String competence;
	private String information;
	private String ville;
	private String date;
	private String lien;
	private String status;
	
	
	
	public Stage(String entreprise, String emploi, String ville) {
		super();
		this.entreprise = entreprise;
		this.emploi = emploi;
		this.ville = ville;
	}
	public Stage() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Stage(int id, String date, String status) {
		super();
		this.id = id;
		this.date = date;
		this.status = status;
	}
	
	public Stage(String entreprise, String emploi, String competence, String information, String ville, String lien) {
		super();
		this.entreprise = entreprise;
		this.emploi = emploi;
		this.competence = competence;
		this.information = information;
		this.ville = ville;
		this.lien = lien;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEntreprise() {
		return entreprise;
	}
	public void setEntreprise(String entreprise) {
		this.entreprise = entreprise;
	}
	public String getEmploi() {
		return emploi;
	}
	public void setEmploi(String emploi) {
		this.emploi = emploi;
	}
	public String getCompetence() {
		return competence;
	}
	public void setCompetence(String competence) {
		this.competence = competence;
	}
	public String getInformation() {
		return information;
	}
	public void setInformation(String information) {
		this.information = information;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getLien() {
		return lien;
	}
	public void setLien(String lien) {
		this.lien = lien;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return ville;
	}
}
