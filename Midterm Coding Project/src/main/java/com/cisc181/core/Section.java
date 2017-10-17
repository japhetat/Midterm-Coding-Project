package com.cisc181.core;

import java.util.UUID;

public class Section {
	
	private UUID CourseID;
	private UUID SemesterID;
	private UUID SectionID;
	private int RoomID;
	
	/**
	 * @param courseID
	 * @param semesterID
	 * @param sectionID
	 * @param roomID
	 */
	public Section(UUID courseID, UUID semesterID, UUID sectionID, int roomID) {
		CourseID = courseID;
		SemesterID = semesterID;
		SectionID = sectionID;
		RoomID = roomID;
	}

	/**
	 * @return the courseID
	 */
	public UUID getCourseID() {
		return CourseID;
	}

	/**
	 * @param courseID the courseID to set
	 */
	public void setCourseID(UUID courseID) {
		CourseID = courseID;
	}

	/**
	 * @return the semesterID
	 */
	public UUID getSemesterID() {
		return SemesterID;
	}

	/**
	 * @param semesterID the semesterID to set
	 */
	public void setSemesterID(UUID semesterID) {
		SemesterID = semesterID;
	}

	/**
	 * @return the sectionID
	 */
	public UUID getSectionID() {
		return SectionID;
	}

	/**
	 * @param sectionID the sectionID to set
	 */
	public void setSectionID(UUID sectionID) {
		SectionID = sectionID;
	}

	/**
	 * @return the roomID
	 */
	public int getRoomID() {
		return RoomID;
	}

	/**
	 * @param roomID the roomID to set
	 */
	public void setRoomID(int roomID) {
		RoomID = roomID;
	}
	
	

}
