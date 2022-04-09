package de.dhbw.t2inf3001.pe.Interfaces;

import de.dhbw.t2inf3001.pe.PhoneNumber;

public interface LanguageFactory {
	PhoneNumber createPhoneNumber(String s1, String s2, String s3);
	Address createAddress(String s1, String s2, String s3, String s4, String s5);
}