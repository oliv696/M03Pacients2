package com.company;

import java.util.Scanner;

public class Buscar {

	//**************************************************************
	
	public Pacient buscarMenu(){
			
			System.out.println("Per quin camp vols buscar el pacient?\n1)Nom\n2)Primer Cognom\n" +
					"3)Segon Cognom\n4)DNI");
			Scanner sc=new Scanner(System.in);
			int opcio=sc.nextInt();
			
			switch(opcio){
			case 1:buscarNom();
				break;
			case 2:buscarCognom1();
				break;
			case 3:buscarCognom2();
				break;
			case 4:buscarDni();
				break;
			default: System.out.println("Opció no vàlida [1-4]");
			}
			
			sc.close();
			
			return null;
			
		}
		
		public Pacient buscarNom(){
			
			
			
			
			return p;
		}
		public Pacient buscarCognom1(){
			return p;
		}
		public Pacient buscarCognom2(){
			return p;
		}
		
		public Pacient buscarDni(){
			
			System.out.println("Introdueix un DNI\n");
			Scanner sc=new Scanner(System.in);
			String dni=sc.nextLine();
			
			boolean trobat=false;

			for(Pacient p:Program.pacients){				//buscamos en lista pacients
				if(p.getDni().equalsIgnoreCase(dni)){	
					System.out.println(p);
					trobat=true;
				}
			}
			if(!trobat){									//si no está, lo buscamos en la lista arxivats
				for(Pacient pa:Program.pacientsArxivats){
					if(pa.getDni().equalsIgnoreCase(dni)){	
						System.out.println(pa);
						trobat=true;
					}
				}
				if(!trobat){
					System.out.println("Pacient no trobat");
				}
			}
			
			
			
			return p;
		}
		
		
		//*********************************************************************************

}
