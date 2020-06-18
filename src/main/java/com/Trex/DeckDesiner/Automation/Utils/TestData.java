package com.Trex.DeckDesiner.Automation.Utils;

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
