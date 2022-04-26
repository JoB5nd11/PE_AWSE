package de.dhbw.t2inf3001.pe.LangGB;

import de.dhbw.t2inf3001.pe.Interfaces.PhoneNumber;

//Spezielle klasse f�r die Darstellung der Telefonnummern in der GB-Darstellung, implementiert das PhoneNumber-Interface
public class GB_PhoneNumber implements PhoneNumber{

	private String areaCode;
	private String subscriber;

	//Standardkonstruktor nimmt die Telefondaten als �bergabeparameter entgegen und setzt die Klassenvariablen
	public GB_PhoneNumber(String areaCode, String subscriber, String country) {
		this.areaCode = areaCode;
		this.subscriber = subscriber;
	}
	
	//Format Methode nutzt das Builder Pattern zur Formatierung der Telefondaten im GB-Format
	//Anschlie�end werden diese als String zur�ck gegeben (Getter)
	public String format() {
		StringBuilder builder = new StringBuilder();
		builder.append(areaCode);
		builder.append(" ");
		builder.append(subscriber);
		return builder.toString();
	}
	
	//FormatInternational Methode nutzt ebenfalls das Builder Pattern zur Formatierung der internationalen Telefondaten im GB-Format
	//Anschlie�end werden diese als String zur�ck gegeben (Getter)
	public String formatInternational() {
		StringBuilder builder = new StringBuilder();
		builder.append("+44-");
		builder.append(areaCode.substring(1));
		builder.append("-");
		builder.append(subscriber);
		return builder.toString();
	}
}
