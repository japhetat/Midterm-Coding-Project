package com.cisc181.core;

public class PersonException extends Exception {
	
	private Person ThePerson;

	/**
	 * @param message
	 * @param thePerson
	 */
	public PersonException(String message, Person thePerson) {
		super(message);
		ThePerson = thePerson;
	}

	/**
	 * @return the thePerson
	 */
	
	public Person getThePerson() {
		return ThePerson;
	}
	
}
