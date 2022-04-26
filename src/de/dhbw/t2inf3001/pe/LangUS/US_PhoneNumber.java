package de.dhbw.t2inf3001.pe.LangUS;

import de.dhbw.t2inf3001.pe.Interfaces.PhoneNumber;

//Spezielle klasse für die Darstellung der Telefonnummern in der US-Darstellung, implementiert das PhoneNumber-Interface
public class US_PhoneNumber implements PhoneNumber{

	private String areaCode;
	private String subscriber;

	//Standardkonstruktor nimmt die Telefondaten als Übergabeparameter entgegen und setzt die Klassenvariablen
	public US_PhoneNumber(String areaCode, String subscriber, String country) {
		this.areaCode = areaCode;
		this.subscriber = subscriber;
	}
	
	//Format Methode nutzt das Builder Pattern zur Formatierung der Telefondaten im US-Format
	//Anschließend werden diese als String zurück gegeben (Getter)
	public String format() {
		StringBuilder builder = new StringBuilder();
		builder.append(areaCode);
		builder.append(" ");
		builder.append(subscriber);
		return builder.toString();
	}
	
	//FormatInternational Methode nutzt ebenfalls das Builder Pattern zur Formatierung der internationalen Telefondaten im US-Format
	//Anschließend werden diese als String zurück gegeben (Getter)
	public String formatInternational() {
		StringBuilder builder = new StringBuilder();
		builder.append("+1-");
		builder.append(areaCode.substring(1));
		builder.append("-");
		builder.append(subscriber);
		return builder.toString();
	}
}
