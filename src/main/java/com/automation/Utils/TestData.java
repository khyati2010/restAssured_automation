package com.automation.Utils;

import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.person.Person;



public class TestData {
	
	
	
	
	public static Person getPersonData()
	{
		Fairy fairy = Fairy.create();
		Person person=fairy.person();
		return person;
	}

}
