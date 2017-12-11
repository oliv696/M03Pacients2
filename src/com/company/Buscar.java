package com.company;

import java.util.Scanner;

public class Buscar {

	//**************************************************************

	public static Pacient buscarMenu(){

		System.out.println("Per quin camp vols buscar el pacient?\n1)Nom\n2)Cognom\n" +
				"3)DNI\n4)Edat\n5)Telèfon\n6)Alçada\n7)Pes");
		Scanner sc=new Scanner(System.in);
		int opcio=sc.nextInt();sc.nextLine();

		Pacient pacient=null;
		switch(opcio){
		case 1:pacient=buscarNom(); break;
		case 2:pacient=buscarCognom(); break;
		case 3:pacient=buscarDni();break;
		case 4:pacient=buscarEdat();break;
		case 5:pacient=buscarTelf();break;
		case 6:pacient=buscarAlcada();break;
		case 7:pacient=buscarPes();break;
		default: System.out.println("Opció no vàlida [1-7]");
		}
		//sc.close();
		return pacient;
	}

	//TODO: Fallo de base: Buscar por nom, alçada, cognoms i pes solo devuelve el primero que encuentra, sin embargo
	//varias personas pueden tener atributos iguales.
	// Solución 1: Crear función auxiliar que muestre todos los que ha encontrado (y añadir a arraylist auxiliar de encontrados?)
	// y pida al usuario cual de ellos hay que devolver
	// Solución 2: Añadir esa función dentro de cada una

	private static Pacient buscarNom(){

		System.out.println("Introdueix un nom\n");
		Scanner sc=new Scanner(System.in);
		String nom=sc.nextLine();
		Pacient pacient=null;

		boolean trobat=false;

		for(Pacient p:Program.pacients){				//buscamos en lista pacients
			if(p.getNom().equalsIgnoreCase(nom)){
				trobat=true;
				pacient=p;
			}
		}
		if(!trobat){									//si no está, lo buscamos en la lista arxivats
			for(Pacient pa:Program.pacientsArxivats){
				if(pa.getNom().equalsIgnoreCase(nom)){	
					trobat=true;
					pacient=pa;
				}
			}
			if(!trobat){
				System.out.println("Pacient no trobat.");	//si tampoco estuviera, imprimimos mensaje
			}
		}
		//sc.close();
		return pacient;


	}

    private static Pacient buscarCognom(){

		System.out.println("Introdueix un cognom\n");
		Scanner sc=new Scanner(System.in);
		String cognom=sc.nextLine();
		Pacient pacient=null;

		boolean trobat=false;

		//TODO: Arreglar segundo apellido
		//TODO: Buscar por los dos apellidos a la vez, o una operación para cada uno?
		//TODO: Ordenar alfabéticamente
		for(Pacient p:Program.pacients){
																//NO FUNCIONA CON EL SEGUNDO APELLIDO!!!!! :S
			String[] cognoms=p.getCognoms().split(" ");
			
			if(cognoms[0].equalsIgnoreCase(cognom) ){			//SI CAMBIAS A [1] QUE ES 2º APELL PETA!
				trobat=true;
				pacient=p;
				System.out.println(cognoms.length);
				System.out.println(cognoms[0]+" "+cognoms[1]);	//LO RARO ESQ AQUI LO IMPRIME BIEN
				
			}
		}
		if(!trobat){	
			
			for(Pacient pa:Program.pacientsArxivats){
				String[] cognoms=pa.getCognoms().split(" ");
				
				if(cognoms[0].equalsIgnoreCase(cognom)){
					trobat=true;
					pacient=pa;
					//System.out.println(pa);
				}
			}
			if(!trobat){
				System.out.println("Pacient no trobat.");	
			}
		}
		//sc.close();
		return pacient;


	}


    private static Pacient buscarDni(){

		System.out.println("Introdueix un DNI\n");
		Scanner sc=new Scanner(System.in);
		String dni=sc.nextLine();
		Pacient pacient=null;

		boolean trobat=false;

		for(Pacient p:Program.pacients){				
			if(p.getDni().equalsIgnoreCase(dni)){	
				pacient=p;
				trobat=true;
			}
		}
		if(!trobat){									
			for(Pacient pa:Program.pacientsArxivats){
				if(pa.getDni().equalsIgnoreCase(dni)){	
					trobat=true;
					pacient=pa;
				}
			}
			if(!trobat){
				System.out.println("Pacient no trobat");	
			}
		}
		//sc.close();
		return pacient;
	}

    private static Pacient buscarEdat(){					////// ???????? no muy util...

		System.out.println("Introdueix una edat\n");
		Scanner sc=new Scanner(System.in);
		int edat=sc.nextInt();sc.nextLine();
		Pacient pacient=null;

		boolean trobat=false;

		for(Pacient p:Program.pacients){				
			if(p.obtenirEdad()==edat){	
				pacient=p;
				trobat=true;
			}
		}
		if(!trobat){									
			for(Pacient p:Program.pacientsArxivats){	
				if(p.obtenirEdad()==edat){	
					pacient=p;
					trobat=true;
				}
			}
			if(!trobat){
				System.out.println("Edad no trobada");	
			}
		}
		//sc.close();
		return pacient;
	}

    private static Pacient buscarTelf(){

		System.out.println("Introdueix un telèfon\n");
		Scanner sc=new Scanner(System.in);
		String telf=sc.nextLine();
		Pacient pacient=null;

		boolean trobat=false;

		for(Pacient p:Program.pacients){				
			if(p.getTelf().equalsIgnoreCase(telf)){	
				pacient=p;
				trobat=true;
			}
		}
		if(!trobat){									
			for(Pacient pa:Program.pacientsArxivats){
				if(pa.getTelf().equalsIgnoreCase(telf)){	
					trobat=true;
					pacient=pa;
				}
			}
			if(!trobat){
				System.out.println("Aquest telèfon no existeix.");	
			}
		}
		//sc.close();
		return pacient;
	}

    private static Pacient buscarAlcada(){

		System.out.println("Introdueix una alçada en cm\n");
		Scanner sc=new Scanner(System.in);
		int alcada=sc.nextInt();sc.nextLine();
		Pacient pacient=null;

		boolean trobat=false;

		for(Pacient p:Program.pacients){				
			if(p.getAlcada()==alcada){	
				pacient=p;
				trobat=true;
			}
		}
		if(!trobat){									
			for(Pacient p:Program.pacientsArxivats){	
				if(p.getAlcada()==alcada){	
					pacient=p;
					trobat=true;
				}
				if(!trobat){
					System.out.println("No n'hi ha pacients amb aquesta alçada.");	
				}
			}
		}

		//sc.close();
		return pacient;
	}

    private static Pacient buscarPes(){

		System.out.println("Introdueix un pes en kg.\n");
		Scanner sc=new Scanner(System.in);
		int pes=sc.nextInt();
		Pacient pacient=null;

		boolean trobat=false;

		for(Pacient p:Program.pacients){				
			if(p.getPes()==pes){	
				pacient=p;
				trobat=true;
			}
		}
		if(!trobat){									
			for(Pacient p:Program.pacientsArxivats){	
				if(p.getPes()==pes){	
					pacient=p;
					trobat=true;
				}
				if(!trobat){
					System.out.println("No n'hi ha pacients amb aquest pes.");
				}
			}
			
		}
		//sc.close();
		return pacient;
	}

	
	
}
