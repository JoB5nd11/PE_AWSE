package de.dhbw.t2inf3001.pe.LangFR;

import de.dhbw.t2inf3001.pe.PhoneNumber;

public class FR_PhoneNumber implements PhoneNumber{

	private String areaCode;
	private String subscriber;


	public FR_PhoneNumber(String areaCode, String subscriber, String country) {
		this.areaCode = areaCode;
		this.subscriber = subscriber;
	}
	
	public String format() {
		StringBuilder builder = new StringBuilder();
		builder.append(areaCode);
		builder.append(" ");
		builder.append(subscriber);
		return builder.toString();
	}
	
	public String formatInternational() {
		StringBuilder builder = new StringBuilder();
		builder.append("+33-");
		builder.append(areaCode.substring(1));
		builder.append("-");
		builder.append(subscriber);
		return builder.toString();
	}
}
