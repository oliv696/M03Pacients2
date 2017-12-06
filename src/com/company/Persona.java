package com.company;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Persona {
	
	public enum Genere{
		DONA,HOME
	}

	private String nom;
	private String cognoms;
	private LocalDate dataNaix;

	private Genere genere;

	 
	
	public Persona() {
	}


	public Persona(String nombre, String cognoms, LocalDate dataNaix, Genere genere) {
		super();
		this.nom = nombre;
		this.cognoms=cognoms;
		this.dataNaix = dataNaix;
		this.genere = genere;
	}


	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCognoms() {
		return cognoms;
	}

	public void setCognoms(String cognoms) {
		this.cognoms = cognoms;
	}

	public int obtenirEdad() {
		return (int) (ChronoUnit.DAYS.between(dataNaix,LocalDate.now())) / 365;
	}

	public LocalDate getDataNaix() {
		return dataNaix;
	}

	public void setDataNaix(LocalDate dataNaix) {
		this.dataNaix = dataNaix;
	}


	public Genere getGenere() {
		return genere;
	}


	public void setGenere(Genere genere) {
		this.genere = genere;
	}


	@Override
	public String toString() {
		return "Persona " +
				"\n-------"+
				"\nNombre: " + nom +
				"\nCognoms: " + cognoms + 
				"\nData de naixement: "+dataNaix+
				"\nGènere: "+genere+
				"\n";
	}
}
