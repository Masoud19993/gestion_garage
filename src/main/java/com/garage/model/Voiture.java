package com.garage.model;

import jakarta.persistence.*;


@Entity
@Table(name = "voitures")
public class Voiture {
	
	@Id
	private String immatriculation;
	
	private String marque;
	private String modele;
	private String etat;
	
	
	public Voiture() {}
	
	public Voiture(String immatriculation, String marque, String modele, String etat) {
		this.immatriculation = immatriculation;
		this.marque = marque;
		this.modele = modele;
		this.etat = etat;
	}
	
	// Getters & Setters
	public String getImmatriculation() {return this.immatriculation;}
	public void setImmatriculation(String immatriculation) {this.immatriculation = immatriculation;}
	
	public String getMarque() {return this.marque;}
	public void setMarque(String marque) {this.marque = marque;}
	
	public String getModele() {return this.modele;}
	public void setModele(String modele) {this.modele = modele;}
	
	public String getEtat() {return this.etat;}
	public void setEtat(String etat) {this.etat = etat;}

}
