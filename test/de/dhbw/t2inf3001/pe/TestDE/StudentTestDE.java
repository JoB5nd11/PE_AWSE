package de.dhbw.t2inf3001.pe.TestDE;

import static org.junit.Assert.*;
import org.junit.Test;

import de.dhbw.t2inf3001.pe.Student;
import de.dhbw.t2inf3001.pe.LangDE.DE_Factory;

public class StudentTestDE {
	private Student createStudent() {
		return new Student("111", "Torsten", "Schmied", "Gneisenaustr. 4 Jasmindorf 41232 DE", "092217 84457", new DE_Factory());
	}
	
	@Test
	public void testStudentAdressFormat() {
		Student s = createStudent();
		String expected = "Gneisenaustr. 4\n41232 Jasmindorf";
		assertEquals(expected, s.getAddress());
	}
	
	@Test
	public void testStudentPhoneFormat() {
		Student s = createStudent();
		String expected = "092217-84457";
		assertEquals(expected, s.getPhone());
	}
	
	@Test
	public void testStudentInternationalPhoneFormat() {
		Student s = createStudent();
		String expected = "+49-92217-84457";
		assertEquals(expected, s.getIntlPhone());
	}
}
