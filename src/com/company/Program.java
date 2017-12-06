package com.company;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;


public class Program {   //PROBAD¡OOOO

	DateTimeFormatter format=DateTimeFormatter.ofPattern("d/MM/yyy");

	static HashSet<Pacient> pacients = new HashSet<Pacient>();
	static HashSet<Pacient> pacientsArxivats = new HashSet<Pacient>();

	//TODO: Es una cola
	static HashSet<Pacient> esperaOp = new HashSet<Pacient>();


	static String fichero="/home/oliv/pacients.csv";

	//2.1 Carregar pacients
	public void carregar()throws IOException, ClassNotFoundException {

		BufferedReader br = new BufferedReader(new FileReader(new File(fichero)));
		String line;
		while ((line = br.readLine()) != null) {

			String[] entries = line.split(",");

			Pacient pacient = new Pacient(entries[1], entries[2], LocalDate.parse(entries[3],format),
					Persona.Genere.valueOf(entries[4].toUpperCase()), Double.parseDouble(entries[7]), Double.parseDouble(entries[6]),
					entries[5], entries[0]);

			if(pacients.contains(pacient)){
				System.out.println("S'ha eliminat un pacient repetit.\n");
			}else{
				pacients.add(pacient);
			}


		}br.close();

		//		for(Pacient p:pacients){
		//			System.out.println(p);
		//		}
	}


	//2.2 Crear nou pacient
	public void nouPacient(){

		Scanner sc=new Scanner(System.in);
		System.out.println("Nom: ");
		String nom=sc.nextLine();

		System.out.println("Cognom: ");
		String cognom=sc.nextLine();

		System.out.println("Data de naixement: ");
		LocalDate data= LocalDate.parse(sc.nextLine(),format);

		System.out.println("Gènere: ");
		String genere=sc.nextLine().toUpperCase();

		System.out.println("Alçada: ");
		double alcada=sc.nextDouble();

		System.out.println("Pes: ");
		double pes=sc.nextDouble();

		sc.nextLine();

		System.out.println("Telèfon: ");
		String telf=sc.nextLine();

		System.out.println("DNI: ");
		String dni=sc.nextLine();

		Pacient p=new Pacient(nom,cognom,data, Persona.Genere.valueOf(genere),alcada,pes,telf,dni);
		sc.close();

		if(pacients.contains(p)){
			System.out.println("S'ha eliminat el pacient repetit perquè estava repetit.\n");
		}else{
			pacients.add(p);
			System.out.println("Pacient afegit correctament.");
		}
	}


	//2.3 Arxivar pacient
	public void arxivarPacient() throws ClassNotFoundException, IOException{
		Scanner sc=new Scanner(System.in);
		System.out.println("Introdueix el DNI d'un pacient: ");
		String dni=sc.nextLine();
		Pacient tmpPacient = null;

		for(Pacient p:pacients){
			if(p.getDni().equalsIgnoreCase(dni)){	
				tmpPacient=p;
				break;
			}
		}

		if(tmpPacient!=null){
			pacients.remove(tmpPacient);
			pacientsArxivats.add(tmpPacient);		
			System.out.println("S'ha arxivat correctament.");
		} else {
			System.out.println("Aquest pacient no existeix.");
		}

		sc.close();
	}

	//2.4 Esborrar pacient
	public void esborrarPacients(String dni){
		Pacient tmpPacient = null;

		for(Pacient p:pacients){
			if(p.getDni().equalsIgnoreCase(dni)){	
				tmpPacient=p;
			}
		}
		if(tmpPacient!=null){
			pacients.remove(tmpPacient);
			tmpPacient=null;
		}
		for(Pacient p:pacientsArxivats){
			if(p.getDni().equalsIgnoreCase(dni)){	
				tmpPacient=p;
			}
		}if(tmpPacient!=null){
			pacientsArxivats.remove(tmpPacient);
		}
	}

	//2.5 Veure pacient
	public void llistarPacient(String dni){

		boolean trobat=false;

		for(Pacient p:pacients){
			if(p.getDni().equalsIgnoreCase(dni)){	
				System.out.println(p);
				trobat=true;
			}
		}
		if(!trobat){
			for(Pacient pa:pacientsArxivats){
				if(pa.getDni().equalsIgnoreCase(dni)){	
					System.out.println(pa);
					trobat=true;
				}
			}
			if(!trobat){
				System.out.println("Pacient no trobat");
			}
		}
	}

	//2.6 Posar pacient en llista d'espera
	public void posarEspera(String dni){

		boolean trobat=false;

		for(Pacient p:pacients){
			if(p.getDni().equalsIgnoreCase(dni)){	
				esperaOp.add(p);
				trobat=true;
			}
		}
		if(!trobat){
			for(Pacient pa:pacientsArxivats){
				if(pa.getDni().equalsIgnoreCase(dni)){	
					esperaOp.add(pa);
					trobat=true;
				}
			}
			if(!trobat){
				System.out.println("Pacient no trobat");
			}
		}
	}

	//TODO Cambiar a cola - queue
	//2.7 Enviar pacient a operar
	public void operar(String dni){

		Pacient tmpPacient = null;

		for(Pacient p:esperaOp){
			if(p.getDni().equalsIgnoreCase(dni)){	
				tmpPacient=p;
			}
		}
		if(tmpPacient!=null){
			esperaOp.remove(tmpPacient);
		}else{
			System.out.println("Pacient no trobat.");
		}
	}

	//TODO: Submenú buscar (metodo)
//	//2.8 Cercar pacient
//	public void cercarP(){
//
//		System.out.println("Introdueix un nom, un cognom o un DNI:");
//		Scanner sc=new Scanner(System.in);
//		String x=sc.nextLine();
//
//		for(Pacient pp:pacients){
//			if(pp.nombre.equalsIgnoreCase(x)||pp.cognoms.equalsIgnoreCase(x)||pp.getDni().equalsIgnoreCase(x)){
//				System.out.println("Nom: "+pp.nombre+"\nCognoms: "+pp.cognoms+"\nDNI: "+pp.getDni());
//			}
//		}
//
//	}

	//2.8.2 
	public void llistarEdats(){
		Scanner sc=new Scanner(System.in);
		System.out.println("Introdueix una edat: ");
		int edat1=sc.nextInt();
		System.out.println("Introdueix una altra edat");
		int edat2=sc.nextInt();
		sc.close();

		HashSet<Pacient> edades = new HashSet<Pacient>();

		int e1;

		for(Pacient p:pacients){
			e1=p.obtenirEdad();
			if(e1>=edat1 && e1<=edat2){
				edades.add(p);
			}
		}
		for(Pacient p:pacientsArxivats){
			e1=p.obtenirEdad();
			if(e1>=edat1 && e1<=edat2){
				edades.add(p);
			}
		}

		List<Pacient> ordenados=new ArrayList<>();
		ordenados.addAll(edades);
		Collections.sort(ordenados, Pacient.comparator);

		for(Pacient p:ordenados){
			System.out.println(p);
		}
	}


	//2.8.3
	public void llistarCognom(){

		String[] tmp;
		
		for(Pacient p:pacients){
			tmp=p.getCognoms().split(" ");
		}
		
		///comparo segunda pos del array con el apellido introducido, si coincide lo guardo en array, comparator para ordenar con apellido
	}

	//2.8.6
	public void llistarTelf(){

		for(Pacient p:pacients){
			p.getTelf().substring(p.getTelf().length()-3);
			System.out.println(p.getTelf().substring(p.getTelf().length()-3));
		}
	}

}






