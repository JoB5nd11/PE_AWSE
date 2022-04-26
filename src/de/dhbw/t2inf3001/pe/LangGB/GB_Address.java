package de.dhbw.t2inf3001.pe.LangGB;

import de.dhbw.t2inf3001.pe.Interfaces.Address;

//Spezielle klasse für die Darstellung der Adressen in der GB-Darstellung, implementiert das Address-Interface 
public class GB_Address implements Address{
	
	private String street;
	private String streetNumber;
	private String city;
	private String zipCode;
	
	//Standardkonstruktor nimmt die Adressdaten als Übergabeparameter entgegen und setzt die Klassenvariablen
	public GB_Address(String street, String streetNumber, String city, String zipCode, String country) {
		this.street = street;
		this.streetNumber = streetNumber;
		this.city = city;
		this.zipCode = zipCode;
	}

	//Format Methode nutzt das Builder Pattern zur Formatierung der Adressdaten im GB-Format
	//Anschließend werden diese als String zurück gegeben (Getter)
	//Source: https://www.parcelmonkey.com/how-to-guides/how-to-address-mail-to-uk
	public String format() {
		StringBuilder builder = new StringBuilder();
		builder.append(streetNumber);
		builder.append(" ");
		builder.append(street);
		builder.append("\n");
		builder.append(city.toUpperCase());
		builder.append("\n");
		builder.append(zipCode.toUpperCase());
		return builder.toString();
	}
}
