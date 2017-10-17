package com.cisc181.core;

import java.util.Date;
import java.util.UUID;

public class Semester {
	
	private UUID SemesterID;
	private Date StartDate;
	private Date EndDate;
	
	/**
	 * @param semesterID
	 * @param startDate
	 * @param endDate
	 */
	public Semester(UUID semesterID, Date startDate, Date endDate) {
		SemesterID = semesterID;
		StartDate = startDate;
		EndDate = endDate;
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
	 * @return the startDate
	 */
	public Date getStartDate() {
		return StartDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		StartDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return EndDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		EndDate = endDate;
	}
	
	

}
