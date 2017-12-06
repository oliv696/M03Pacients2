package com.company;

import java.util.Scanner;

public class Buscar {

	//**************************************************************

	public static Pacient buscarMenu(){

		System.out.println("Per quin camp vols buscar el pacient?\n1)Nom\n2)Primer Cognom\n" +
				"3)Segon Cognom\n4)DNI\n5)Edat\n6)Telèfon\n7)Alçada\n8)Pes");
		Scanner sc=new Scanner(System.in);
		int opcio=sc.nextInt();

		Pacient pacient=null;
		switch(opcio){
		case 1:pacient=buscarNom(); break;
		case 2:pacient=buscarCognom1(); break;
		case 3:pacient=buscarCognom2(); break;
		case 4:pacient=buscarDni();break;
		case 5:pacient=buscarEdat();break;
		case 6:pacient=buscarTelf();break;
		case 7:pacient=buscarAlcada();break;
		case 8:pacient=buscarPes();break;
		default: System.out.println("Opció no vàlida [1-8]");
		}
		sc.close();
		return pacient;
	}

	public static Pacient buscarNom(){

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
		sc.close();
		return pacient;


	}

	public static Pacient buscarCognom1(){

		System.out.println("Introdueix un cognom\n");
		Scanner sc=new Scanner(System.in);
		String cognom=sc.nextLine();
		Pacient pacient=null;

		boolean trobat=false;

		for(Pacient p:Program.pacients){				
			if(p.getCognoms().equalsIgnoreCase(cognom)){
				trobat=true;
				pacient=p;
			}
		}
		if(!trobat){									
			for(Pacient pa:Program.pacientsArxivats){
				if(pa.getNom().equalsIgnoreCase(cognom)){	
					trobat=true;
					pacient=pa;
				}
			}
			if(!trobat){
				System.out.println("Pacient no trobat.");	
			}
		}
		sc.close();
		return pacient;


	}

	public static Pacient buscarCognom2(){
		return null;
	}

	public static Pacient buscarDni(){

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
		sc.close();
		return pacient;
	}

	public static Pacient buscarEdat(){					////// ???????? no muy util...

		System.out.println("Introdueix una edat\n");
		Scanner sc=new Scanner(System.in);
		int edat=sc.nextInt();
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
		sc.close();
		return pacient;
	}

	public static Pacient buscarTelf(){	

		System.out.println("Introdueix un DNI\n");
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
		sc.close();
		return pacient;
	}

	public static Pacient buscarAlcada(){	

		System.out.println("Introdueix una alçada en cm\n");
		Scanner sc=new Scanner(System.in);
		int alcada=sc.nextInt();
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
		}sc.close();
		return pacient;
	}

	public static Pacient buscarPes(){	

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
					System.out.println("No n'hi ha pacients amb aquesta alçada.");	
				}
			}
			
		}sc.close();
		return pacient;
	}
}
