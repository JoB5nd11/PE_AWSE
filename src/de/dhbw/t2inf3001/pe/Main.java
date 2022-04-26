/*
 * Programmenwurf für die Vorlesung "Advanced Software-Engineering (Java II)" an der DHBW Heidenheim
 * Erstellt von Johannes Bendler und Florian Deufel im April 2022
 * Copyright (c) 2022 by Johannes Bendler und Florian Deufel. All rights reserved.
 */


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

import de.dhbw.t2inf3001.pe.Interfaces.LanguageFactory;
import de.dhbw.t2inf3001.pe.LangDE.DE_Factory;
import de.dhbw.t2inf3001.pe.LangFR.FR_Factory;
import de.dhbw.t2inf3001.pe.LangGB.GB_Factory;
import de.dhbw.t2inf3001.pe.LangUS.US_Factory;
import de.dhbw.t2inf3001.pe.exceptions.StudentNotFoundException;

//Die Main Class steuert die Anwendung und bietet Interaktionsmöglichkeiten für die Benutzer
public class Main {
	
	private static BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
	private static String id = null;
	private static Student student;
	private static String lang;
	
	public static void main(String[] args) throws Exception {
		setLanguage();		//Setzen der Spracheinstellung
		mainMenue();		//Aufrufen des Hauptmenüs
	}
	
	
	//Hauptmenü Methode
	public static void mainMenue() throws IOException, InterruptedException {
		System.out.println("Welcome to the DHBW Student Management System!");
		
		
		boolean run = true;		//Benötigt zum verlassen der Schleife aus der Switch Case Abfrage
		while (run) {			//Hauptmenüschleife, läuft bis run über den Menüpunkt 6 auf false gesetzt wird

			printMenu();		//Ausgabe des Menütextes
			
			int action = 0;		//Variable zum speichern der Nutzereingabe
			
			try {
				 action = Integer.parseInt(cin.readLine());		//Einlesen der Nutzereingabe / Auswahl 
			} catch (NumberFormatException e) {
				System.out.println("Invalid Input!");			//Fehlermeldung bei ungültiger Eingabe (z. B. Buchstaben)
				continue;
			}
			
			if(1 < action && action < 6) {		//Abfangen der Nutzereingaben / Menüpunkte 2-5, sofern noch kein Student ausgewählt wurde
				if(student == null) {
					printNoStudentSelectedError();		//Ausgabe der Fehlermeldung
					selectStudent();					//Direkter Aufruf zum Auswahl einer Studenten ID
				}
			}
			
			//Switch Case Abfrage für die Auswahl der Menüpunkte
			switch(action) {	
			
			//Case 1 erlaubt die Auswahl eines Studenten über die ID
			case 1:
				clearConsole();		//Löschen der Konsole
				selectStudent();	//Aufruf zur eingabe einer Studenten ID
				
				if(student.getFirstName() != null) {		//Überprüfung ob der Student in der Datenbank gefunden wurde
					clearConsole();							
					System.out.println("Successfully selected " + student.getInfo() +"\n");		//Erfolgmeldung und Ausgabe der Studenten Informationen
				}
				break;
			
			//Case 2 gibt die Informationen des derzeit ausgewählten Studenten aus
			case 2:
				if(student.getInfo() == null) {		//Abfangen falls Information nicht erhalten wird
					printCannotGetProperty("Info");		//Ausgabe Fehlermeldung
					break;
				}
				clearConsole();
				System.out.println(student.getInfo());		//Ausgabe der Informationen
				break;
			
			//Case 3 gibt die Addressdaten des derzeit ausgewählten Studenten aus
			case 3:
				if(student.getAddress() == null) {		//Abfangen falls Information nicht erhalten wird
					printCannotGetProperty("Address");		//Ausgabe der Fehlermeldung
					break;
				}
				clearConsole();
				System.out.println(student.getAddress());		//Ausgabe der Addresse
				break;
			
			//Case 4 gibt die Telefonummer des derzeit ausgewählten Studenten aus
			case 4:
				if(student.getPhone() == null) {		//Abfangen falls Information nicht erhalten wird
					printCannotGetProperty("Phone");	//Ausgabe Fehlermeldung
					break;
				}
				clearConsole();
				System.out.println(student.getPhone());		//Ausgabe der Telefonnummer
				break;
			
			//Case 5 gibt die internationale Telefonnummer des derzeit ausgewählten Studenten aus
			case 5:
				if(student.getIntlPhone() == null) {		//Abfangen falls Information nicht erhalten wird
					printCannotGetProperty("IntlPhone");		//Ausgabe der Fehlermeldung
					break;
				}
				clearConsole();
				System.out.println(student.getIntlPhone());		//Ausgabe der internationalen Telefonnummer
				break;
			
			//Case 5 beendet das Programm
			case 6:
				run = false;		//run Variable wird auf false gesetzt und die Schleife damit verlassen
				break;
			
			//Der default Case wird ausgeführt wenn keine Übereinstimmung zu 1-6 gefunden wurde -> Falscheingabe
			default:
				clearConsole();
				System.out.println("Error: This input is not supported! \n");		//Ausgabe Fehlermeldung 
				break;
			}
			if(run == true) {		//Falls das Programm nicht beendet wurde, wird hier auf eine <enter> Eingabe des Nutzers gewartet
				waitForUser();		//Erlaubt es dem Nutzer die Ausgabe zu lesen und anschließend zu bestätigen
			}
			clearConsole();
		}
		
		System.out.println("Thank you for using the DHBW Student Management System :-)");		//Ausgabe beim Beenden des Programmes
		cin.close();	//Schließen des BufferedReaders
		
		Thread.sleep(2000);		//Zeit damit obige Meldung dargestellt werden kann
		System.exit(0);		//Beenden des Programms
	}
	
	
	//Methode erlaubt es einen Student über die ID auszuwählen
	private static void selectStudent() throws IOException, InterruptedException {
		
		System.out.println("Enter Student-Id");
		System.out.println("---------------------------------");
		System.out.print("> ");
		try {
			id = cin.readLine();		//Einlesen der Nutereingabe
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//Erstellen einer LanguageFactory für die zuvor ausgewählte Sprache
		try {
			LanguageFactory factory = getFactoryFromLanguage(lang);		//Erstellen einer neuen Factory abhängig von der ausgewählten Sprache
			student = new Student(id, factory);		//Erstellen eines neuen Studenten, übergabe der id und factory im Konstruktor
			
		}catch(Exception e) {
			printStudentNotFoundInDataStore(id);		//Abfangen falls der Student nicht gefunden wurde
			waitForUser();
			mainMenue();
		}
	}
	
	//Methode erstellt passende Factory abhängig von der Spracheinstellung, bei der Erweiterung der unterstützen Darstellungen kann diese Methode leicht angepasst werden
	private static LanguageFactory getFactoryFromLanguage(String lang) {		//Gewählter Sprachenkürzel ist Übergabeparameter
		LanguageFactory factory = null;
		
		switch(lang) {		//Erstellen der passenden Factory abhängig vom Sprachkürzel
		case "DE":
			factory = new DE_Factory();
			break;
			
		case "FR":
			factory = new FR_Factory();
			break;
			
		case "GB":
			factory = new GB_Factory();
			break;
			
		case "US":
			factory = new US_Factory();
			break;
		
		//Der default Case fängt ab, falls das übergebene Sprachkürzel nicht gefunden wurde
		default:
			printLanguageNotFoundError();
			try {
				waitForUser();
				setLanguage();		//Programm fordert Nutzer zum setzen der Sprache auf
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return factory;		//Rückgabe der erstellten Factory
	}
	
	//Fehlermeldung: Es wurde kein Student ausgewählt
	private static void printNoStudentSelectedError() {
		clearConsole();
		System.out.println("You have not selected a student yet. \r\n"
				+ "Please select a student [1] before using the options 2-5 \n");
	}
	
	//Fehlermeldung: Das Property konnte nicht abgerufen werden
	private static void printCannotGetProperty(String prop) {
		clearConsole();
		System.out.println("The selected Student does not have to property: <"
						 + prop + ">\n");
	}
	
	//Fehlermeldung: Der Student wurde nicht im DataStore gefunden
	private static void printStudentNotFoundInDataStore(String id) {
		clearConsole();
		System.out.println("No Student with the ID: <" + id + "> was found in the DataStore.\n"
						 + "Please consider choosing another ID or contact the support.\n");
	}
	
	//Fehlermeldung: Die eingegebene Sprache wird nicht untersützt
	private static void printLanguageNotFoundError() {
		clearConsole();
		System.out.println("There appears to be a problem with your selected language.\n"
						 + "Please select it again or consider using another language");
	}
	
	//Methode "leert" die Konsole (funktioniert auch in Eclipse)
	private static void clearConsole() {
		for(int i = 0; i < 100; i++) {
			System.out.println("\n");
		}
	}
	
	//Methode wartet darauf, dass der Nutzer Enter drückt
	private static void waitForUser() throws IOException {
		System.out.println("---------------------------------");
		System.out.println("Press <Enter> to continue");
		cin.readLine();
		clearConsole();
	}
	
	//Methode erlaubt das Setzen der Darstellungsprache, hierbei werden dem Nutzer automatisch die unterstützen Spachen ausgegeben
	private static void setLanguage() throws IOException {
		
		String directory = "\\"+System.getProperty("user.dir")+"\\src\\de\\dhbw\\t2inf3001\\pe";		//Speichert das Arbeitsverzeichnis der Anwendung in der Variablen directory
		LinkedHashSet<String> hashSet = new LinkedHashSet<String>();		//HashSet vermeidet Dopplungen
		Iterator itr;

		File[] files = new File(directory).listFiles();		//Speichern der Dateinamen im Verzeichnis

		for (File file : files) {
		    if (file.isDirectory() && file.getName().contains("Lang")) {		//Durchsucht das Verzeichnis nach Unterverzeichnisen mit "Lang"
		       hashSet.add(file.getName().split("Lang")[1]);		//Speichert das abgeschnittene Sprachkürzel im hashSet (hierdurch ergeben sich die unterstützen Sprachen)
		    }
		}
		
		String input;
		String systemLang = System.getProperty("user.country");		//Ermitteln der Systemspracheinstellung ggf. nur unter Windows?
		System.out.println("Initial setup");
		System.out.println("---------------------------------");
		System.out.println("We have detected that your system is localized in " + systemLang
						 + ".\nIf you want to set your application to " + systemLang + " Enter <" + systemLang + "> otherwise enter the desired location.");
		System.out.print("\nCurrently The following locations are supported: ");
		
		
		//Ausgabe aller Sprachen im hashSet über den Iterator
		itr = hashSet.iterator();
		while (itr.hasNext()) {
          System.out.print(itr.next() + ", ");
        }
		
		System.out.println("\n---------------------------------");
		System.out.print(">");
		input = cin.readLine();		//Einlesen der Spracheinstellung (Nutzereingabe)
		
		clearConsole();
		
		//Überprüfen ob die Nutzereingabe im hashSet vorkommt
		if(hashSet.contains(input)) {
			lang = input;
			System.out.println("\nThe display setting was successfully set to " + lang);		//Ausgabe bei Erfolg, anschließend wird die Methode verlassen
			waitForUser();	
		}else {
			System.out.println("Not Supported");		//Ausgabe bei Misserfolg
			waitForUser();
			setLanguage();		//Erneuter rekursiver Aufruf der Methode erlaubt es dem Nutzer eine andere Sprache zu wählen
		}
	}
	
	//Methode gibt das Hauptmenü aus
	private static void printMenu() {
		System.out.println("Please select an option...");
		System.out.println("---------------------------------");
		System.out.println("[1] - Search for student by id");		
		System.out.println("[2] - Display info");					
		System.out.println("[3] - Display address");
		System.out.println("[4] - Display phone number");
		System.out.println("[5] - Display int'l phone number");
		System.out.println("[6] - Exit program");
		System.out.println("---------------------------------");
		System.out.print("> ");
	}
}
