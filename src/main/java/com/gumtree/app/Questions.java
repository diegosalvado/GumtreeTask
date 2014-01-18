package com.gumtree.app;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gumtree.model.Person;

public class Questions {

	static Logger logger = LoggerFactory.getLogger(Reader.class);
	
	/*
	 * @param List<Person>
	 * @return integer
	 * iterate the list of persons and return the number of males
	 */
	public static int number_males(List<Person> list) {
		
		logger.info("Number of males method\n");
		
		int total=0;
		
		for(Person p:list) {
			if(p.getGender().equals("Male")) total++;
		}
		
		return total;
	}
	
}
