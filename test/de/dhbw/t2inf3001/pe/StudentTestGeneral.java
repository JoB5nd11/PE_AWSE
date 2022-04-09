package de.dhbw.t2inf3001.pe;

import static org.junit.Assert.*;
import org.junit.Test;

import de.dhbw.t2inf3001.pe.LangDE.DE_Factory;

public class StudentTestGeneral {
	//A Student Object is created here instead of loading one of the datastore.
	//This is because it is not guaranteed that the datastore stays the same.
	//If it changes the Unit Test might fail, even though the code is working.
	//Maybe there is a better solution like making a copy of the datastore or one just
	//for testing, but I don't know ( 0 _ 0 )
	private Student createStudent() {
		return new Student("42", "Reiner", "Testfall", "Teststr. 9 Teststadt 37742 DE", "01234 56789", new DE_Factory());
	}
	
	@Test
	public void testStudentFirstName() {
		Student s = createStudent();
		String expected = "Reiner";
		assertEquals(expected, s.getFirstName());
	}
	
	@Test
	public void testStudentLastName() {
		Student s = createStudent();
		String expected = "Testfall";
		assertEquals(expected, s.getLastName());
	}
	
	@Test
	public void testStudentInfoFormat() {
		Student s = createStudent();
		String expected = "42: Reiner Testfall";
		assertEquals(expected, s.getInfo());
	}
}
