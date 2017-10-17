package com.cisc181.core;

import java.util.UUID;

import com.cisc181.eNums.eMajor;

public class Course {
	
	private UUID CourseID;
	private String CourseName;
	private int GradePoints;
	private eMajor Major;	

	/**
	 * @param couseID
	 * @param courseName
	 * @param gradePoints
	 * @param major
	 */
	public Course(UUID courseID, String courseName, int gradePoints, eMajor major) {
		CourseID = courseID;
		CourseName = courseName;
		GradePoints = gradePoints;
		Major = major;
	}

	/**
	 * @return the couseID
	 */
	public UUID getCouseID() {
		return CourseID;
	}

	/**
	 * @param couseID the couseID to set
	 */
	public void setCourseID(UUID courseID) {
		CourseID = courseID;
	}

	/**
	 * @return the courseName
	 */
	public String getCourseName() {
		return CourseName;
	}

	/**
	 * @param courseName the courseName to set
	 */
	public void setCourseName(String courseName) {
		CourseName = courseName;
	}

	/**
	 * @return the gradePoints
	 */
	public int getGradePoints() {
		return GradePoints;
	}

	/**
	 * @param gradePoints the gradePoints to set
	 */
	public void setGradePoints(int gradePoints) {
		GradePoints = gradePoints;
	}

	/**
	 * @return the major
	 */
	public eMajor getMajor() {
		return Major;
	}

	/**
	 * @param major the major to set
	 */
	public void setMajor(eMajor major) {
		Major = major;
	}
	
	
	
}
