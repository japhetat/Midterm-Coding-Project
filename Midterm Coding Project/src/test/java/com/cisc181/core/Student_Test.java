package com.cisc181.core;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Random;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cisc181.eNums.eMajor;

import java.util.UUID;


public class Student_Test {
	
	private static double sectionCreditHour = 3;
	
	private static SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
	
	private static ArrayList<Course> courseList = new ArrayList<Course>();
	
	private static ArrayList<Semester> semesterList = new ArrayList<Semester>();
	
	private static ArrayList<Section> sectionList = new ArrayList<Section>();
	
	private static ArrayList<Student> studentList = new ArrayList<Student>();

	@BeforeClass
	public static void setup() {
		try {
			Course course1 = new Course(UUID.randomUUID(), 
					"Computer Science II", 95, eMajor.COMPSI);
			Course course2 = new Course(UUID.randomUUID(), 
					"Chemistry", 82, eMajor.CHEM);
			Course course3 = new Course(UUID.randomUUID(), 
					"Nursing", 92, eMajor.NURSING);
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
			fail("unexpected exception");
		}
		
	}

	private static double getStudentGPA(ArrayList<Enrollment> enrollments, Student student) {
		double studentGradeTotal = 0.0;
		for (int i = 0; i < enrollments.size(); i++) {
			Enrollment enrollment = enrollments.get(i);
			if (enrollment.getStudentID().equals(student.getStudentID())) {
				studentGradeTotal = studentGradeTotal + enrollment.getGrade();
			}
		}
		double studentGPA = (studentGradeTotal * sectionCreditHour) / (sectionList.size() * sectionCreditHour);
		return studentGPA;		
	}
	
	private static double getAverageCourseGrade(ArrayList<Enrollment> enrollments, Section section) {
		double sectionGradeTotals = 0.0;
		for (int i = 0; i < enrollments.size(); i++) {
			Enrollment enrollment = enrollments.get(i);
			if (enrollment.getSectionID().equals(section.getSectionID())) {
				sectionGradeTotals = sectionGradeTotals + enrollment.getGrade();
			}
		}
		double averageSectionGrade = sectionGradeTotals / studentList.size();
		return averageSectionGrade;
	}
	
	@Test
	public void testGrades() {
				
		ArrayList<Enrollment> enrollments = new ArrayList<Enrollment>();
		HashMap<UUID, Double> studentGPAs = new HashMap<UUID, Double>();
		HashMap<UUID, Double> sectionGradeTotals = new HashMap<UUID, Double>();
		
		Random rand = new Random();
		
		for (int i = 0; i < studentList.size(); i++) {
			
			Student student = studentList.get(i);
			double studentGradeTotal = 0.0;			
			for (int j = 0; j < sectionList.size(); j++) {
				Section section = sectionList.get(j);				
				Enrollment enrollment = new Enrollment(section.getSectionID(), student.getStudentID());
				double grade = rand.nextInt(5); // 4 = A, 3 = B, 2 = C, 1 = D, 0 = F
				studentGradeTotal = studentGradeTotal + grade;
				enrollment.setGrade(grade);
				enrollments.add(enrollment);
				
				if (i == 0) {
					sectionGradeTotals.put(section.getSectionID(), grade);
				}
				else {
					double currentGradeTotal = sectionGradeTotals.get(section.getSectionID());
					sectionGradeTotals.put(section.getSectionID(), (currentGradeTotal + grade));
				}
			}
			
			double studentGPA = (studentGradeTotal * sectionCreditHour) / (sectionList.size() * sectionCreditHour);
			studentGPAs.put(student.getStudentID(), studentGPA);			
		}
		
		for (int i = 0; i < studentList.size(); i++) {
			Student student = studentList.get(i);
			double studentGPA = getStudentGPA(enrollments, student);
			System.out.println("studentGPA: "+studentGPA);
			assertEquals(studentGPAs.get(student.getStudentID()), studentGPA, 0.0);
		}
		
		for (int i = 0; i < sectionList.size(); i++) {
			Section section = sectionList.get(i);
			double averageCourseGrade = getAverageCourseGrade(enrollments, section);
			double expectedAverageCourseGrade = sectionGradeTotals.get(section.getSectionID()) / studentList.size();
			System.out.println("averageCourseGrade: "+averageCourseGrade);
			assertEquals(expectedAverageCourseGrade, averageCourseGrade, 0.0);
		}
	}
}