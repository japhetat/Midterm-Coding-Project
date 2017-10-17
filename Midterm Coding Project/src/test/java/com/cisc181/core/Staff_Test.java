package com.cisc181.core;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cisc181.eNums.eTitle;

public class Staff_Test {

	private static SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
			
	private static ArrayList<Staff> staffList = new ArrayList<Staff>();
	
	@BeforeClass
	public static void setup() {
		try {
			Staff staff1 = new Staff("John", "Mason", "Smith", formatter.parse("10/15/1997"), "Texas", "(302)-333-3333", "john@example.com", "1-2 Tuesday", 3, 
					80000.0, formatter.parse("10/15/2007"), eTitle.MR);
			Staff staff2 = new Staff("Japhet", "Aklilu", "Teshale", formatter.parse("09/16/1997"), "Delaware", "(302)-528-8949", "japhetteshale@gmail.com", "2-4 Monday", 1, 
					120000.0, formatter.parse("09/16/2017"), eTitle.MR);
			Staff staff3 = new Staff("Senait", "Rachel", "Tesfaye", formatter.parse("03/09/1980"), "New York", "(302)-259-3689", "senait124@yahoo.com", "11-12 Wednesday", 2, 
					60000.0, formatter.parse("03/09/2008"), eTitle.MRS);
			Staff staff4 = new Staff("Siona", "Angel", "Young", formatter.parse("04/20/1999"), "Florida", "(302)-332-1379", "siona3124@gmail.com", "2-3 Thursady", 4, 
					90000.0, formatter.parse("04/20/2012"), eTitle.MS);
			Staff staff5 = new Staff("Akiliu", "Andrew", "Stewart", formatter.parse("06/06/1966"), "Delaware", "(302)-259-3689", "aklilu.stewart@yahoo.com", "3-4 Friday", 5, 
					100000.0, formatter.parse("06/06/2016"), eTitle.MR);
			staffList.add(staff1);
			staffList.add(staff2);
			staffList.add(staff3);
			staffList.add(staff4);
			staffList.add(staff5);
		}
		catch (Exception e) {
			fail("Unexpected exception");
		}		
	}
	
	@Test
	public void testSalaryData() {
		double sum = 0.0;
		for (int i = 0; i < staffList.size(); i++) {
			sum = sum + staffList.get(i).getSalary();
		}
		double average = sum / staffList.size();
		assertEquals(average, 90000.0, 0);
	}	
	
	@Test
	public void testInvalidPhoneNumber() {
		try {
			Staff staff = staffList.get(0);
			staff.setPhone("1234567890");
			fail("Expected exception to be thrown");
		}
		catch (PersonException e) {
			assertEquals(e.getMessage(), "Phone_number format is incorrect");
		}
	}
	
	@Test
	public void testDOB() {
		try {
			Staff staff = staffList.get(0);
			staff.setDOB(formatter.parse("06/06/1916"));
			fail("Expected exception to be thrown");
		}
		catch (ParseException e) {
			fail("Unexpected parse exception");
		}
		catch (PersonException e) {
			assertEquals(e.getMessage(), "DOB is more than 100 years");
		}
	}

}
