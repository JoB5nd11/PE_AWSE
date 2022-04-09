package de.dhbw.t2inf3001.pe.TestFR;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.dhbw.t2inf3001.pe.Student;
import de.dhbw.t2inf3001.pe.LangFR.FR_Factory;

public class StudentTestFR {
	private Student createStudent() {
		return new Student("59", "Jonathan", "Weston", "Boulevard 123 Toulon 83200 FR", "09248 123545", new FR_Factory());
	}
	
	@Test
	public void testStudentAdressFormat() {
		Student s = createStudent();
		String expected = "123 BOULEVARD\n83200 TOULON";
		assertEquals(expected, s.getAddress());
	}
	
	@Test
	public void testStudentPhoneFormat() {
		Student s = createStudent();
		String expected = "09248 123545";
		assertEquals(expected, s.getPhone());
	}
	
	@Test
	public void testStudentInternationalPhoneFormat() {
		Student s = createStudent();
		String expected = "+33-9248-123545";
		assertEquals(expected, s.getIntlPhone());
	}
}
