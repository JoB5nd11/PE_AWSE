package de.dhbw.t2inf3001.pe.LangFR;

import de.dhbw.t2inf3001.pe.Interfaces.Address;
import de.dhbw.t2inf3001.pe.Interfaces.LanguageFactory;
import de.dhbw.t2inf3001.pe.Interfaces.PhoneNumber;

//Spezielle Factory Klasse für die Darstellung im FR-Format, implementiert die LanguageFactory
//Überschreibt die Methoden aus der Interface-Klasse
public class FR_Factory implements LanguageFactory{
	
	 //Erhält die Telefondaten als Übergabeparameter und gibt diese an ein neues FR_PhoneNumber Objekt weiter
	 @Override 
	 public PhoneNumber createPhoneNumber(String s1, String s2, String s3) {
		 return new FR_PhoneNumber(s1, s2, s3);
	 }

	//Erhält die Adressdaten als Übergabeparameter und gibt diese an ein neues FR_Address Objekt weiter
	 @Override
	 public Address createAddress(String s1, String s2, String s3, String s4, String s5) {
		 return new FR_Address(s1, s2, s3, s4, s5);
	 }
}
