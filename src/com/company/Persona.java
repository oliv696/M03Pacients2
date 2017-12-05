package com.company;
import java.time.LocalDate;

public class Persona {
	
	protected String nombre;
	protected String cognoms;
	protected LocalDate dataNaix;
//	private enum genere{
//		DONA,HOME
//	}
	protected String genere;

	 
	
//	public Persona() {
//		super();
//	}


	public Persona(String nombre, String cognoms, LocalDate dataNaix, String genere) {
		super();
		this.nombre = nombre;
		this.cognoms=cognoms;
		this.dataNaix = dataNaix;
		this.genere = genere;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getCognoms() {
		return cognoms;
	}

	public void setCognoms(String cognoms) {
		this.cognoms = cognoms;
	}

	public int obtenirEdad() {
		
		LocalDate fechaNaix=this.getDataNaix();
		
		LocalDate fechaActual=LocalDate.now();
		
		return fechaActual.getYear()-fechaNaix.getYear();
		
	}
	

	public LocalDate getDataNaix() {
		return dataNaix;
	}


	public void setDataNaix(LocalDate dataNaix) {
		this.dataNaix = dataNaix;
	}


	public String getGenere() {
		return genere;
	}


	public void setGenere(String genere) {
		this.genere = genere;
	}


	@Override
	public String toString() {
		return "Persona " +
				"\n-------"+
				"\nNombre: " + nombre + 
				"\nCognoms: " + cognoms + 
				"\nData de naixement: "+dataNaix+
				"\nGènere: "+genere+
				"\n";
	}
}
