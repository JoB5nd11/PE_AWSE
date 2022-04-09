package de.dhbw.t2inf3001.pe.TestGB;

import static org.junit.Assert.*;
import org.junit.Test;

import de.dhbw.t2inf3001.pe.Interfaces.Address;
import de.dhbw.t2inf3001.pe.LangGB.GB_Address;

public class AddressTestGB {
	@Test
	public void testFormatBasic() {
		Address address = new GB_Address("Predovic Light", "Suite 045", "Lindfort", "2805", "GB");
		String expected = "Suite 045 Predovic Light\nLINDFORT\n2805";
		assertEquals(expected, address.format());
	}
	
	@Test
	public void testFormatItemMissing() {
		Address address = new GB_Address("Flatley Parks", "106", "", "87157", "GB");
		String expected = "106 Flatley Parks\n\n87157";
		assertEquals(expected, address.format());
	}
	
	@Test 
	public void testFormatEmpty() {
		Address address = new GB_Address("", "", "", "", "");
		String expected = " \n\n";
		assertEquals(expected, address.format());
	}
}
