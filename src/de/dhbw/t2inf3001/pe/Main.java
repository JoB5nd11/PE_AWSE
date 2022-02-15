package de.dhbw.t2inf3001.pe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	private static BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws Exception {
		System.out.println("Welcome to the DHBW Student Management System!");

		String id = null;
		
		Student student = null;
		
		boolean run = true;		//Benötigt um Schleife zu verlassen aus Switch Case herraus
		
		while (run) {

			whatWillYouDo();
			
			int action = 0;
			
			try {
				 action = Integer.parseInt(cin.readLine());		//eine Variable entfernt besser?
			} catch (NumberFormatException e) {
				System.out.println("Invalid Input!");
				continue;
			}
			
			
			switch(action) {		//Switch case ggf. Verschlechtbesserung?
			case 1:
				System.out.println("Enter id: ");
				id = cin.readLine();
				student = new Student(id);
				
				if(student.getFirstName() != null) {
				System.out.println("Successfully selected " + student.info() +"\n");
				}
				break;
			case 2:
				System.out.println(student.info());
				break;
			case 3:
				System.out.println(student.address());
				break;
			case 4:
				System.out.println(student.phone());
				break;
			case 5:
				System.out.println(student.intlPhone());
				break;
			case 6:
				run = false;
				break;
			default:
				System.out.println("Error: This input is not supported! \n");
				break;
			}	
		}
		
		System.out.println("Thank you for using the DHBW Student Management System :-)");
		cin.close();
		
		Thread.sleep(2000);		//Zeit damit obige Meldung dargestellt werden kann
		System.exit(0);		//Beenden des Programms
	}

	
	private static void whatWillYouDo() {
		System.out.println("What will you do?");
		System.out.println("[1] - Search for student by id");		//Suche nach ID zielführend?
		System.out.println("[2] - Display info");					//Info gibt nur name aus
		System.out.println("[3] - Display address");
		System.out.println("[4] - Display phone number");
		System.out.println("[5] - Display int'l phone number");
		System.out.println("[6] - Exit program");

	}
	

}
