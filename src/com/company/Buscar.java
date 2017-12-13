package com.company;

import java.util.*;

public class Buscar {

	//**************************************************************

	public static Pacient buscarMenu(boolean toSelect){

		System.out.println("Per quin camp vols buscar el pacient?\n1)Nom\n2)Cognom\n" +
				"3)DNI\n4)Edat\n5)Telèfon\n6)Alçada\n7)Pes");
		Scanner sc=new Scanner(System.in);
		int opcio=sc.nextInt();sc.nextLine();

		Pacient pacient=null;
		switch(opcio){
			case 1:pacient=buscarNom(toSelect); break;
			case 2:pacient=buscarCognom(toSelect); break;
			case 3:pacient=buscarDni();break;
			case 4:pacient=buscarEdat(toSelect);break;
			case 5:pacient=buscarTelf(toSelect);break;
			case 6:pacient=buscarAlcada(toSelect);break;
			case 7:pacient=buscarPes(toSelect);break;
			default: System.out.println("Opció no vàlida [1-7]");
		}
		return pacient;
	}

	private static Pacient seleccionarPacient(List<Pacient> pacients) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("\nSelecciona el pacient: ");
		int seleccio = Integer.parseInt(scanner.nextLine());

		while ((seleccio - 1) >= pacients.size()) {
			System.out.println("Si us plau, selecciona un dels pacients mostrats: ");
			seleccio = Integer.parseInt(scanner.nextLine());
		}

		return pacients.get(seleccio-1);
	}

	private static Pacient buscarNom(boolean toSelect){
		Scanner sc=new Scanner(System.in);

		System.out.println("Introdueix un nom: ");
		String nom=sc.nextLine();

		Pacient pacient=null;
		List<Pacient> trobats = new ArrayList<>();

		for(Pacient p:Program.pacients){
			if (nom.equalsIgnoreCase(p.getNom())) {
				trobats.add(p);
			}
		}

		for(Pacient p:Program.pacientsArxivats){
			if (nom.equalsIgnoreCase(p.getNom())) {
				trobats.add(p);
			}
		}

		if (trobats.size() == 0) {
			System.out.println("Pacient no trobat");
		} else {
			System.out.printf("    ");
			Program.printHeader();
			for (int i = 0; i < trobats.size(); i++) {
				System.out.println("[" + (i+1) + "] " + trobats.get(i));
			}
		}

		if (trobats.size()>1 && toSelect) {
			pacient=seleccionarPacient(trobats);
		}

		return pacient;
	}

	static Pacient buscarCognom(boolean toSelect){
		Scanner sc=new Scanner(System.in);

		System.out.println("Introdueix un cognom: ");
		String cognom=sc.nextLine();

		Pacient pacient=null;
		List<Pacient> trobats = new ArrayList<>();

		for(Pacient p : Program.pacients) {
			if (p.getCognoms().toLowerCase().contains(cognom.toLowerCase())) {
				trobats.add(p);
			}
		}

		for(Pacient p : Program.pacientsArxivats) {
			if (p.getCognoms().toLowerCase().contains(cognom.toLowerCase())) {
				trobats.add(p);
			}
		}

		if (trobats.size() == 0) {
			System.out.println("Pacient no trobat");
		} else {
			Collections.sort(trobats, Comparator.comparing(Persona::getCognoms));
			System.out.printf("    ");
			Program.printHeader();
			for (int i = 0; i < trobats.size(); i++) {
				System.out.println("[" + (i+1) + "]" + " " + trobats.get(i));
			}
		}

		if (trobats.size()>1 && toSelect) {
			pacient=seleccionarPacient(trobats);
		}

		return pacient;
	}


    private static Pacient buscarDni(){
		System.out.println("Introdueix un DNI: ");
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

    private static Pacient buscarEdat(boolean toSelect){
		Scanner sc=new Scanner(System.in);

		System.out.println("Introdueix una edat: ");
		int edat=Integer.parseInt(sc.nextLine());

		Pacient pacient=null;
		List<Pacient> trobats = new ArrayList<>();

		for(Pacient p:Program.pacients){
			if (edat==p.obtenirEdad()) {
				trobats.add(p);
			}
		}

		for(Pacient p:Program.pacientsArxivats){
			if (edat==p.obtenirEdad()) {
				trobats.add(p);
			}
		}

		if (trobats.size() == 0) {
			System.out.println("Pacient no trobat");
		} else {
			System.out.printf("    ");
			Program.printHeader();
			for (int i = 0; i < trobats.size(); i++) {
				System.out.println("[" + (i+1) + "]" + " " + trobats.get(i));
			}
		}

		if (trobats.size()>1 && toSelect) {
			pacient=seleccionarPacient(trobats);
		}

		return pacient;
	}

    private static Pacient buscarTelf(boolean toSelect){
		Scanner sc=new Scanner(System.in);

		System.out.println("Introdueix un telèfon: ");
		String telefon=sc.nextLine();

		Pacient pacient=null;
		List<Pacient> trobats = new ArrayList<>();

		for(Pacient p:Program.pacients){
			if (telefon.equals(p.getTelf())) {
				trobats.add(p);
			}
		}

		for(Pacient p:Program.pacientsArxivats){
			if (telefon.equals(p.getTelf())) {
				trobats.add(p);
			}
		}

		if (trobats.size() == 0) {
			System.out.println("Pacient no trobat");
		} else {
			System.out.printf("    ");
			Program.printHeader();
			for (int i = 0; i < trobats.size(); i++) {
				System.out.println("[" + (i+1) + "]" + " " + trobats.get(i));
			}
		}

		if (trobats.size()>1 && toSelect) {
			pacient=seleccionarPacient(trobats);
		}

		return pacient;
	}

    private static Pacient buscarAlcada(boolean toSelect){
		Scanner sc=new Scanner(System.in);

		System.out.println("Introdueix una alçada en cm: ");
		double alcada=Double.parseDouble(sc.nextLine());

		Pacient pacient=null;
		List<Pacient> trobats = new ArrayList<>();

		for(Pacient p:Program.pacients){
			if (alcada == p.getAlcada()) {
				trobats.add(p);
			}
		}

		for(Pacient p:Program.pacientsArxivats){
			if (alcada == p.getAlcada()) {
				trobats.add(p);
			}
		}

		if (trobats.size() == 0) {
			System.out.println("Pacient no trobat");
		} else {
			System.out.printf("    ");
			Program.printHeader();
			for (int i = 0; i < trobats.size(); i++) {
				System.out.println("[" + (i+1) + "]" + " " + trobats.get(i));
			}
		}

		if (trobats.size()>1 && toSelect) {
			pacient=seleccionarPacient(trobats);
		}

		return pacient;
	}

    private static Pacient buscarPes(boolean toSelect){

		System.out.println("Introdueix un pes en kg.\n");
		Scanner sc=new Scanner(System.in);

		System.out.println("Introdueix una alçada en cm: ");
		double pes=Double.parseDouble(sc.nextLine());

		Pacient pacient=null;
		List<Pacient> trobats = new ArrayList<>();

		for(Pacient p:Program.pacients){
			if (pes == p.getPes()) {
				trobats.add(p);
			}
		}

		for(Pacient p:Program.pacientsArxivats){
			if (pes == p.getPes()) {
				trobats.add(p);
			}
		}

		if (trobats.size() == 0) {
			System.out.println("Pacient no trobat");
		} else {
			System.out.printf("    ");
			Program.printHeader();
			for (int i = 0; i < trobats.size(); i++) {
				System.out.println("[" + (i+1) + "]" + " " + trobats.get(i));
			}
		}

		if (trobats.size()>1 && toSelect) {
			pacient=seleccionarPacient(trobats);
		}

		return pacient;
	}

	
	
}
