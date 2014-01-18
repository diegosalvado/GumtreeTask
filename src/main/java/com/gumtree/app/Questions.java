package com.gumtree.app;

import java.util.Collections;
import java.util.Comparator;
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
	

	/*
	 * @param List<Person>
	 * @return Person
	 * iterate the list of persons and return the oldest
	 */
	public static Person oldest(List<Person> list) {
		
		logger.info("Oldest person method\n");
		
		Collections.sort(list, comparator);  
		
		return list.get(0);
		
	}

	  
	
	 static Comparator<Person> comparator = new Comparator<Person>() {
		    public int compare( Person a, Person b ) {
	
		    	return a.getAge().compareTo(b.getAge());
		    	
	       }
	  };    	
	
}



