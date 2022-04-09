package de.dhbw.t2inf3001.pe.LangDE;

import de.dhbw.t2inf3001.pe.PhoneNumber;
import de.dhbw.t2inf3001.pe.Interfaces.Address;
import de.dhbw.t2inf3001.pe.Interfaces.LanguageFactory;

public class DE_Factory implements LanguageFactory{

	@Override
	public PhoneNumber createPhoneNumber(String s1, String s2, String s3) {
		
		return new DE_PhoneNumber(s1, s2, s3);
	}

	@Override
	public Address createAddress(String s1, String s2, String s3, String s4, String s5) {
		return new DE_Address(s1, s2, s3, s4, s5);
	}

}