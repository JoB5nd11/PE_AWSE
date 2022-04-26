package de.dhbw.t2inf3001.pe.Interfaces;

//Übergeordnetes Factory interface, welches verschiedene Factory-Typen erlaubt (z. B. DE_Factory)
//Kann an dieser Stelle leicht erweitert werden, wenn ein zusätzliches Attribut aufgenommen werden soll
public interface LanguageFactory {
	PhoneNumber createPhoneNumber(String s1, String s2, String s3);
	Address createAddress(String s1, String s2, String s3, String s4, String s5);
}
