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


public class Program {   

	DateTimeFormatter format=DateTimeFormatter.ofPattern("d/MM/yyy");
	static String fichero="/home/oliv/pacients.csv";

	static HashSet<Pacient> pacients = new HashSet<Pacient>();
	static HashSet<Pacient> pacientsArxivats = new HashSet<Pacient>();
	//TODO: Es una cola    ??¿¿¿ no hace falta !
	static HashSet<Pacient> esperaOp = new HashSet<Pacient>();


	//2.1 Carregar pacients desde CSV ******************************************************************************************
	public void carregar()throws IOException, ClassNotFoundException {

		BufferedReader br = new BufferedReader(new FileReader(new File(fichero)));
		String line;
		while ((line = br.readLine()) != null) {											//FUNCIONA!!!!

			String[] entries = line.split(",");

			Pacient pacient = new Pacient(entries[1], entries[2], LocalDate.parse(entries[3],format),
					Persona.Genere.valueOf(entries[4].toUpperCase()), Double.parseDouble(entries[7]),
					Double.parseDouble(entries[6]),entries[5], entries[0]);

			if(pacients.contains(pacient)){
				System.out.println("S'ha eliminat un pacient repetit.\n");    //només per missatge (hashSet)
			}else{
				pacients.add(pacient);										  //añadimos el paciente 
			}
		}br.close();

		//				for(Pacient p:pacients) {
		//					System.out.println(p);
		//				}
	}


	//2.2 Crear nou pacient ****************************************************************************************************
	public void nouPacient(){

		Scanner sc=new Scanner(System.in);
		System.out.println("Nom: ");
		String nom=sc.nextLine();

		System.out.println("Cognom: ");
		String cognom=sc.nextLine();

		System.out.println("Data de naixement: [dd/mm/yyyy]");
		LocalDate data= LocalDate.parse(sc.nextLine(),format);
		
		System.out.println("Gènere: [home-dona]");
		String genere=sc.nextLine().toUpperCase();
		while(!(genere.equalsIgnoreCase("home")||genere.equalsIgnoreCase("dona"))){
			System.out.println("Incorrecte!! [home-dona]");
			 genere=sc.nextLine().toUpperCase();
		}
		System.out.println("Alçada: ");
		double alcada=sc.nextDouble();												//FUNCIONA!!!!

		System.out.println("Pes: ");
		double pes=sc.nextDouble();sc.nextLine();

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
			System.out.println("Pacient afegit correctament.\n");
		}
	}


	//2.3 Arxivar pacient ***********************************************************************************************************
	public void arxivarPacient() throws ClassNotFoundException, IOException{

		Pacient p=Buscar.buscarMenu();
		if(p!=null){
			pacients.remove(p);																//FUNCIONA!!!!
			pacientsArxivats.add(p);		
			System.out.println("S'ha arxivat correctament.\n");
		}
	}

	//2.4 Esborrar pacient *************************************************************************************************************
	public void esborrarPacients(){

		Pacient p=Buscar.buscarMenu();

		if(p!=null){
			pacients.remove(p);																//FUNCIONA!!!!
			pacientsArxivats.remove(p);		
			System.out.println("S'ha esborrat correctament.\n");
		}
	}

	//2.5 Veure pacient ******************************************************************************************************************
	public void llistarPacient(){

		Pacient p=Buscar.buscarMenu();			
																								//FUNCIONA!!!!
		if(p!=null){	
			System.out.println(p);
		}
		System.out.println("\n");

	}

	//2.6 Posar pacient en llista d'espera *********************************************************************************************
	public void posarEspera(){

		Pacient p=Buscar.buscarMenu();

		if(p!=null){																	//FUNCIONA!!!!
			esperaOp.add(p);		
		}
	}


	//2.7 Enviar pacient a operar **********************************************************************************************************
	public void operar(){

		Pacient p=Buscar.buscarMenu();

		if(p!=null){																	//FUNCIONA!!!!
			esperaOp.remove(p);
			System.out.println("Operant pacient.\n");
		}
	}

	//2.8.1 Cercar pacients  **************************************************************************************************************
	public void llistarPacients(){ 

		System.out.println(Buscar.buscarMenu());							//FALTA, ya que solo listaría uno
	}


	//2.8.2 Llistar pacients per rang edats *************************************************************************************************
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
				edades.add(p);											//FUNCIONA!!!! aunque no está hecho con el método buscar
			}															//             ya que sólo encontraría una edad 
		}
		for(Pacient p:pacientsArxivats){
			e1=p.obtenirEdad();
			if(e1>=edat1 && e1<=edat2){
				edades.add(p);
			}
		}

		List<Pacient> ordenados=new ArrayList<Pacient>();
		ordenados.addAll(edades);
		Collections.sort(ordenados, Pacient.comparator);

		for(Pacient p:ordenados){
			System.out.println(p);
		}
		System.out.println("\n");
	}


	//2.8.3 Llistar pacients amb el mateix cognom, alfabeticament *************************************************************************
	public void llistarCognom(){

		String[] tmp;

		for(Pacient p:pacients){
			tmp=p.getCognoms().split(" ");
		}

		///comparo segunda pos del array con el apellido introducido, si coincide lo guardo en array, comparator para ordenar con apellido
	}

	//2.8.4 Llistar pacients fins a pes concret ******************************************************************************************
	public void llistarPes(){

		ArrayList<Pacient> pes = new ArrayList<Pacient>();
		
		
		
	}

	//2.8.5 Llistar pacients fins a alçada concreta **************************************************************************************
	public void llistarAlcada(){

	}

	//2.8.6 Donat 3 nums, imprimir telfs que acaben així *********************************************************************************
	public void llistarTelf(){														

		Scanner sc=new Scanner(System.in);
		System.out.println("Introdueix un primer nombre");
		int num1=sc.nextInt();
		System.out.println("Introdueix un segon nombre");
		int num2=sc.nextInt();
		System.out.println("Introdueix un tercer nombre");
		int num3=sc.nextInt();																//FUNCIONA!!!!

		ArrayList<String> telefonos = new ArrayList<String>();
		String nums=String.valueOf(num1)+String.valueOf(num2)+String.valueOf(num3);

		for(Pacient p:pacients){
			String telfs=p.getTelf().substring(p.getTelf().length()-3);
			if(telfs.equals(nums)){
				telefonos.add(p.getTelf());
			}
		}
		for(Pacient pa:pacientsArxivats){
			String telfs2=pa.getTelf().substring(pa.getTelf().length()-3);
			if(telfs2.equals(nums)){
				telefonos.add(pa.getTelf());
			}
		}

		if(telefonos.isEmpty()){
			System.out.println("No n'hi ha telèfons acabats amb aquesta xifra.\n");
		}else{
			for(String t:telefonos){
				System.out.println(t);
			}
		}
		sc.close();
		System.out.println("\n");
	}

	//2.8.7 Imprimir pacients llista espera ***********************************************************************************************
	public void llistarEsperantOp(){

		for(Pacient p:esperaOp){															//FUNCIONA!!!!
			System.out.println(p);
		}
		System.out.println("\n");
	}
	//2.9.1 Estadistica per edat, pes i alçada *********************************************************************************************
	public void estadisticaPesEdatAlt(){

	}

	//2.9.2 Estadistica per franja edat, pes o alçada, freqüencia ***************************************************************************
	public void freqRangEdatPesAlt(){

	}

	//2.9.3 Quantitat pacients en llista espera *********************************************************************************************
	public void quantitatEsperant(){
		System.out.println("Hi ha "+esperaOp.size()+" pacient a la llista d'espera.\n");			//FUNCIONA!!!!
	}

	//Menú Principal ************************************************************************************************************************
	public void menuP() throws ClassNotFoundException, IOException{


		System.out.println("\n*********Benvingut/da!*********\n");
		Scanner sc=new Scanner(System.in);
		int opcio;
		do{
			System.out.println("Menú Principal:");
			System.out.println("1. Carregar pacients\n2. Crear nou pacient\n3. Arxivar pacient\n" +
					"4. Esborrar pacient\n5. Veure pacient\n6. Enviar pacient a llista d'espera\n" +
					"7. Enviar pacient a operar\n8. Llistats\n9. Estadístiques\n0. Sortir");
			System.out.println("\nIntrodueix una opció:");
			opcio=sc.nextInt();

			switch(opcio){

			case 1:carregar();break;
			case 2:nouPacient();break;													//CUANDO HACE EL BUCLE LA SEGUNDA VEZ PETA :S :S
			case 3:arxivarPacient();break;
			case 4:esborrarPacients();break;											//cuando lo pruebas dos veces me refiero
			case 5:llistarPacient();break;
			case 6:posarEspera();break;
			case 7:operar();break;
			case 8:llistatMenu();break;
			case 9:estadistiquesMenu();break;
			case 0:System.out.println("Fins aviat!!");break;
			default: System.out.println("Opció incorrecta! [0-9]\n");
			sc.nextLine();
			}


		}while(opcio!=0);
		sc.close();
	}

	// Submenu para los listados *************************************************************************************************************
	public void llistatMenu(){	

		System.out.println("\n*Llistats*\n");
		Scanner sc=new Scanner(System.in);
		int opcio;

		System.out.println("1. Pel nom, cognom, o Dni\n2. Per rang d'edat\n3. Pel cognom\n" +
				"4. Pel pes (kg)\n5. Per l'alçada\n6. Pel telèfon\n" +
				"7. Llista d'espera\n");
		System.out.println("\nIntrodueix una opció:");
		opcio=sc.nextInt();

		switch(opcio){

		case 1:llistarPacients();break;
		case 2:llistarEdats();break;
		case 3:llistarCognom();break;
		case 4:llistarPes();break;
		case 5:llistarAlcada();break;
		case 6:llistarTelf();break;
		case 7:llistarEsperantOp();break;
		default: System.out.println("Opció incorrecta! [1-7]\n");
		sc.nextLine();
		}

		sc.close();



	}

	// Submenu para las estadisticas **********************************************************************************************************
	public void estadistiquesMenu(){  
		System.out.println("*Estadístiques*\n");
		Scanner sc=new Scanner(System.in);
		int opcio;

		System.out.println("1. Freqüents per l'edat, pes i alçada\n" +
				"2. Freqüència de pes, edat o alçada\n3. Quantitat en llista d'espera\n");
		System.out.println("\nIntrodueix una opció:");
		opcio=sc.nextInt();

		switch(opcio){

		case 1:estadisticaPesEdatAlt();break;
		case 2:freqRangEdatPesAlt();break;
		case 3:quantitatEsperant();break;
		default: System.out.println("Opció incorrecta! [1-3]\n");
		sc.nextLine();
		}

		sc.close();


	}
}






