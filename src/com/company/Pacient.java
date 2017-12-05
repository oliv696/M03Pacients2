package com.company;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Comparator;

@SuppressWarnings("serial")
public class Pacient extends Persona implements Serializable,Comparable{

	
	
	private double alcada;
	private double pes;
	private String telf;
	private String dni;
	
	public Pacient(String nombre, String cognoms, LocalDate dataNaix,
			String genere, double alcada, double pes, String telf, String dni) {
		super(nombre, cognoms, dataNaix, genere);
		this.alcada = alcada;
		this.pes = pes;
		this.telf = telf;
		this.dni = dni;
	}


	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pacient other = (Pacient) obj;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		return true;
	}




	@Override
	public String toString() {
		return "Pacient  " +
				"\n-------"+
				"\nNombre: " + nombre + 
				"\nCognoms: " + cognoms + 
				"\nData de naixement: "+dataNaix+
				"\nGènere: "+genere+
				"\nAlçada: " + alcada + 
				"\nPes: " + pes+ 
				"\nTelf: " + telf+
				"\nDNI: " + dni;
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
	
	static Comparator<Pacient> comparator = new Comparator<Pacient>() {
		   @Override
		   public int compare(Pacient u1, Pacient u2) {
			Integer a = u1.obtenirEdad();
			Integer b = u2.obtenirEdad();
		      return a.compareTo(b);
		   }
		};

	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

}
