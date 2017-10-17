package com.cisc181.core;

import java.util.UUID;

public class Enrollment {
	
	private UUID SectionID;
	private UUID StudentID;
	private UUID EnrollmentID;
	private double Grade;
	
	private Enrollment() {
	}

	/**
	 * @param sectionID
	 * @param studentID
	 */
	public Enrollment(UUID sectionID, UUID studentID) {
		SectionID = sectionID;
		StudentID = studentID;
		this.EnrollmentID = UUID.randomUUID();
	}

	/**
	 * @return the grade
	 */
	public double getGrade() {
		return Grade;
	}

	/**
	 * @param grade the grade to set
	 */
	public void setGrade(double grade) {
		Grade = grade;
	}

	/**
	 * @return the sectionID
	 */
	public UUID getSectionID() {
		return SectionID;
	}

	/**
	 * @return the studentID
	 */
	public UUID getStudentID() {
		return StudentID;
	}

	/**
	 * @return the enrollmentID
	 */
	public UUID getEnrollmentID() {
		return EnrollmentID;
	}
	
	
	

}
