package com.cisc181.core;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cisc181.eNums.eMajor;

import java.util.UUID;


public class Student_Test {
	
	private static SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
	
	private static ArrayList<Course> courseList = new ArrayList<Course>();
	
	private static ArrayList<Semester> semesterList = new ArrayList<Semester>();
	
	private static ArrayList<Section> sectionList = new ArrayList<Section>();
	
	private static ArrayList<Student> studentList = new ArrayList<Student>();

	@BeforeClass
	public static void setup() {
		try {
			Course course1 = new Course(UUID.randomUUID(), "Computer Science II", 95, eMajor.COMPSI);
			Course course2 = new Course(UUID.randomUUID(), "Chemistry", 82, eMajor.CHEM);
			Course course3 = new Course(UUID.randomUUID(), "Nursing", 92, eMajor.NURSING);
			courseList.add(course1);
			courseList.add(course2);
			courseList.add(course3);
			Semester semester1 = new Semester(UUID.randomUUID(), 
					formatter.parse("8/29/2016"), formatter.parse("9/25/2016"));
			Semester semester2 = new Semester(UUID.randomUUID(), 
					formatter.parse("2/4/2017"), formatter.parse("5/25/2017"));
			semesterList.add(semester1);
			semesterList.add(semester2);
			Section section1 = new Section(course1.getCouseID(), 
					semester1.getSemesterID(), UUID.randomUUID(), 349);
			Section section2 = new Section(course2.getCouseID(), 
					semester2.getSemesterID(), UUID.randomUUID(), 123);
			Section section3 = new Section(course3.getCouseID(), 
					semester1.getSemesterID(), UUID.randomUUID(), 235);
			Section section4 = new Section(course1.getCouseID(), 
					semester2.getSemesterID(), UUID.randomUUID(), 412);
			Section section5 = new Section(course2.getCouseID(), 
					semester1.getSemesterID(), UUID.randomUUID(), 156);
			Section section6 = new Section(course3.getCouseID(), 
					semester2.getSemesterID(), UUID.randomUUID(), 501);			
			sectionList.add(section1);
			sectionList.add(section2);
			sectionList.add(section3);
			sectionList.add(section4);
			sectionList.add(section5);
			sectionList.add(section6);
			Student student1 = new Student("David", "Martin", "Stewart", 
					formatter.parse("09/16/1997"), eMajor.BUSINESS, "Delaware", "(302)-467-3289", 
					"japhetteshale@gmail.com");
			Student student2 = new Student("Eva", "Lily", "Young", 
					formatter.parse("03/14/1997"), eMajor.CHEM, "Delaware", "(302)-456-6443", 
					"evayoung@gmail.com");
			Student student3 = new Student("Taki", "Argo", "Wilson", 
					formatter.parse("01/23/1999"), eMajor.COMPSI, "New York", "(412)-245-8799", 
					"taki434@gmail.com");
			Student student4 = new Student("Ranchel", "Anne", "Mouri", 
					formatter.parse("09/13/2000"), eMajor.NURSING, "Alabama", "(512)-123-2647", 
					"ranmouri289@gmail.com");
			Student student5 = new Student("Conan", "Holmes", "Edogawa", 
					formatter.parse("05/4/2000"), eMajor.PHYSICS, "Washington", "(202)-685-2374", 
					"edogawaholmes@yahoo.com");
			Student student6 = new Student("Ai", "Sherry", "Haibara", 
					formatter.parse("04/13/1999"), eMajor.BUSINESS, "Delaware", "(302)-378-5829", 
					"haibara4x2@gmail.com");
			Student student7 = new Student("Naruto", "Namikaze", "Uzumaki", 
					formatter.parse("10/10/1996"), eMajor.CHEM, "Pennsylvania", "(132)-987-6543", 
					"uzumakinaruto9@gmail.com");
			Student student8 = new Student("Bob", "Victory", "Jones", 
					formatter.parse("11/20/1999"), eMajor.COMPSI, "Florida", "(602)-467-3492", 
					"japhetteshale@gmail.com");
			Student student9 = new Student("Anne", "Muzi", "Jackson", 
					formatter.parse("07/14/1997"), eMajor.NURSING, " Maryland", "(369)-380-3863", 
					"waterjackson@yahoo.com");
			Student student10 = new Student("Martian", "James", "Chase", 
					formatter.parse("01/29/1997"), eMajor.PHYSICS, " North Carolina", "(519)-395-4962", 
					"martian.chase@yahoo.com");
			studentList.add(student1);
			studentList.add(student2);
			studentList.add(student3);
			studentList.add(student4);
			studentList.add(student5);
			studentList.add(student6);
			studentList.add(student7);
			studentList.add(student8);
			studentList.add(student9);
			studentList.add(student10);
					
		}
		catch (Exception e) {
			
		}
		
	}

	@Test
	public void test() {
		ArrayList<Enrollment> enrollments = new ArrayList<Enrollment>();
		for (int i = 0; i < studentList.size(); i++) {
			for (int j = 0; j < sectionList.size(); j++) {
				Enrollment enrollment = new Enrollment(studentList.get(i).getStudentID(), sectionList.get(j).getSectionID());
				// enrollment.setGrade();
				enrollments.add(enrollment);
			}
		}
	}
}