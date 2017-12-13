package com.company;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Comparator;

@SuppressWarnings({ "serial", "rawtypes" })
public class Pacient extends Persona implements Serializable,Comparable{

	private double alcada;
	private double pes;
	private String telf;
	private String dni;

	public Pacient(String nombre, String cognoms, LocalDate dataNaix, Persona.Genere genere, double alcada, double pes, String telf, String dni) {
		super(nombre, cognoms, dataNaix, genere);
		this.alcada = alcada;
		this.pes = pes;
		this.telf = telf;
		this.dni = dni;
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pacient pacient = (Pacient) o;

        return dni != null ? dni.equals(pacient.dni) : pacient.dni == null;
    }

    @Override
    public int hashCode() {
        return dni != null ? dni.hashCode() : 0;
    }

    @Override
	public String toString() {
		return String.format("%-15s %-15s %-15s %-15s %-15.2f %-15.2f %-15s %-15s",this.getNom(),this.getCognoms(),this.getDataNaix(),this.getGenere(),this.alcada,this.pes,this.telf,this.dni);
	}



	

	public double getAlcada() {
		return alcada;
	}
	public void setAlcada(double alcada) {
		this.alcada = alcada;
	}
	public double getPes() {
		return pes;
	}
	public void setPes(double pes) {
		this.pes = pes;
	}
	public String getTelf() {
		return telf;
	}
	public void setTelf(String telf) {
		this.telf = telf;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}

	//TODO: Revisar esto (es necesario Comparator? Meter en compareTo?)
	static Comparator<Pacient> comparator = (u1, u2) -> ((Integer)u1.obtenirEdad()).compareTo(u2.obtenirEdad());

	public int compareTo(Object arg0) {
		return 0;
	}



}
