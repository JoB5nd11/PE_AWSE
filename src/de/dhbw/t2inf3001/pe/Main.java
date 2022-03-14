package de.dhbw.t2inf3001.pe;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import de.dhbw.t2inf3001.pe.exceptions.StudentNotFoundException;

public class Main {

	private static BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws Exception {
		System.out.println("Welcome to the DHBW Student Management System!");
		String id = null;
		Student student = null;
		
		boolean run = true;		//Benötigt um Schleife zu verlassen aus Switch Case herraus
		while (run) {

			printMenu();
			
			int action = 0;
			
			try {
				 action = Integer.parseInt(cin.readLine());		//eine Variable entfernt besser?
			} catch (NumberFormatException e) {
				System.out.println("Invalid Input!");
				continue;
			}
			
			//There has to be a better way
			switch(action) {		//Switch case ggf. Verschlechtbesserung?
			case 1:
				clearConsole();
				System.out.println("Enter id: ");
				id = cin.readLine();
				
				try {
					student = new Student(id);
				}catch(StudentNotFoundException e) {
					printStudentNotFoundInDataStore(id);
					continue;
				}
				
				if(student.getFirstName() != null) {
					clearConsole();
					System.out.println("Successfully selected " + student.getInfo() +"\n");
				}
				break;
				
			case 2:
				if(student == null) {
					printNoStudentSelectedError();
					continue;
				}
				if(student.getInfo() == null) {
					printCannotGetProperty("Info");
					continue;
				}
				clearConsole();
				System.out.println(student.getInfo());
				break;
				
			case 3:
				if(student == null) {
					printNoStudentSelectedError();
					continue;
				}
				if(student.getAddress() == null) {
					printCannotGetProperty("Address");
					continue;
				}
				clearConsole();
				System.out.println(student.getAddress());
				break;
				
			case 4:
				if(student == null) {
					printNoStudentSelectedError();
					continue;
				}
				if(student.getPhone() == null) {
					printCannotGetProperty("Phone");
					continue;
				}
				clearConsole();
				System.out.println(student.getPhone());
				break;
				
			case 5:
				if(student == null) {
					printNoStudentSelectedError();
					continue;
				}
				if(student.getIntlPhone() == null) {
					printCannotGetProperty("IntlPhone");
					continue;
				}
				clearConsole();
				System.out.println(student.getIntlPhone());
				break;
				
			case 6:
				run = false;
				break;
				
			default:
				clearConsole();
				System.out.println("Error: This input is not supported! \n");
				break;
			}	
		}
		
		System.out.println("Thank you for using the DHBW Student Management System :-)");
		cin.close();
		
		Thread.sleep(2000);		//Zeit damit obige Meldung dargestellt werden kann
		System.exit(0);		//Beenden des Programms
	}
	
	private static void printNoStudentSelectedError() {
		clearConsole();
		System.out.println("You don't have a student selected.\n"
						 + "Choose Option [1] to select a student\n");
	}
	
	private static void printCannotGetProperty(String prop) {
		clearConsole();
		System.out.println("The selected Student does not have to property: <"
						 + prop + ">\n");
	}
	
	private static void printStudentNotFoundInDataStore(String id) {
		clearConsole();
		System.out.println("No Student with the ID: <" + id + "> was found in the DataStore.\n"
						 + "Please consider choosing another ID or contact the support.\n");
	}
	
	private static void clearConsole() {
		//Maybe there is a better way, i didn't find any
		for(int i = 0; i < 100; i++) {
			System.out.println("\n");
		}
	}
	
	private static void printMenu() {
		System.out.println("Please select an option...");
		System.out.println("[1] - Search for student by id");		//Suche nach ID zielführend?
		System.out.println("[2] - Display info");					//Info gibt nur name aus
		System.out.println("[3] - Display address");
		System.out.println("[4] - Display phone number");
		System.out.println("[5] - Display int'l phone number");
		System.out.println("[6] - Exit program");

	}
	

}
