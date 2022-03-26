package de.dhbw.t2inf3001.pe;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

import de.dhbw.t2inf3001.pe.exceptions.StudentNotFoundException;

public class Main {
	

	private static BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
	private static String id = null;
	private static LanguageFactory factory;
	private static Student student;
	private static String lang;
	
	public static void main(String[] args) throws Exception {
		setLanguage();
		mainMenue();

	}
	
	public static void mainMenue() throws IOException, InterruptedException {
		System.out.println("Welcome to the DHBW Student Management System!");
		
		
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
			
			if(1 < action && action < 6) {
				if(student == null) {
					printNoStudentSelectedError();
					selectStudent();
				}
			}
			switch(action) {		
			case 1:
				clearConsole();
				selectStudent();
				
				if(student.getFirstName() != null) {
					clearConsole();
					System.out.println("Successfully selected " + student.getInfo() +"\n");
				}
				break;
				
			case 2:
				if(student.getInfo() == null) {
					printCannotGetProperty("Info");
					break;
				}
				clearConsole();
				System.out.println(student.getInfo());
				break;
				
			case 3:
				if(student.getAddress() == null) {
					printCannotGetProperty("Address");
					break;
				}
				clearConsole();
				System.out.println(student.getAddress());
				break;
				
			case 4:
				if(student.getPhone() == null) {
					printCannotGetProperty("Phone");
					break;
				}
				clearConsole();
				System.out.println(student.getPhone());
				break;
				
			case 5:
				if(student.getIntlPhone() == null) {
					printCannotGetProperty("IntlPhone");
					break;
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
			if(run == true) {
				waitForUser();	
			}
			clearConsole();
		}
		
		System.out.println("Thank you for using the DHBW Student Management System :-)");
		cin.close();
		
		Thread.sleep(2000);		//Zeit damit obige Meldung dargestellt werden kann
		System.exit(0);		//Beenden des Programms
	}
	
	
	private static void selectStudent() throws IOException, InterruptedException {
		
		System.out.println("Enter Student-Id");
		System.out.println("---------------------------------");
		System.out.print("> ");
		try {
			id = cin.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			if(lang == "GB") {
				factory = new GB_Factory();
			}else if(lang == "DE"){
				factory = new DE_Factory();
			}
			student = new Student(id,factory);
		}catch(Exception e) {
			printStudentNotFoundInDataStore(id);
			waitForUser();
			mainMenue();
		}
	}
	
	private static void printNoStudentSelectedError() {
		clearConsole();
		System.out.println("You have not selected a student yet. \r\n"
				+ "Please select a student [1] before using the options 2-5 \n");
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
	
	private static void waitForUser() throws IOException {
		System.out.println("---------------------------------");
		System.out.println("Press <Enter> to continue");
		cin.readLine();
		clearConsole();
	}
	
	private static void setLanguage() throws IOException {
		
		String directory = "\\"+System.getProperty("user.dir")+"\\src\\de\\dhbw\\t2inf3001\\pe";
		LinkedHashSet<String> hashSet = new LinkedHashSet<String>();

		File[] files = new File(directory).listFiles();

		for (File file : files) {
		    if (file.isFile() && file.getName().contains("_")) {
		       String [] stringArr = file.getName().split("_");
		       hashSet.add(stringArr[0]);
		    }
		}
		Iterator itr = hashSet.iterator();
		
		String input;
		String systemLang = "DE";//System.getProperty("user.country");
		System.out.println("Initial setup");
		System.out.println("---------------------------------");
		System.out.println("We have detected that your system is localized in "+systemLang
				+".\nIf you want to set your application to "+systemLang+" Enter <"+systemLang+"> otherwise enter the desired location.");
		System.out.print("\nCurrently The following locations are supported: ");
		while (itr.hasNext()) {
          System.out.print(itr.next()+", ");
        }
		System.out.println("\n---------------------------------");
		System.out.print(">");
		input = cin.readLine();
		
		if(input.equals("DE")) {
			lang = "DE";
		}else if(input.equals("GB")){
				lang = "GB";
			}else {
				System.out.println("Not Supported");
		}
		clearConsole();
		System.out.println("\nThe display setting was successfully set to "+lang);
		waitForUser();	

	}
	
	private static void printMenu() {
		System.out.println("Please select an option...");
		System.out.println("---------------------------------");
		System.out.println("[1] - Search for student by id");		//Suche nach ID zielführend?
		System.out.println("[2] - Display info");					//Info gibt nur name aus
		System.out.println("[3] - Display address");
		System.out.println("[4] - Display phone number");
		System.out.println("[5] - Display int'l phone number");
		System.out.println("[6] - Exit program");
		System.out.println("---------------------------------");
		System.out.print("> ");
	}
	

}
