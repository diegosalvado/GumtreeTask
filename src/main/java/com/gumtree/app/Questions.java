package com.gumtree.app;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.joda.time.Days;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gumtree.config.Config;
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
			if(p.getGender().equals(Config.MALE)) total++;
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
	
	
	/*
	 * @param Person, Person
	 * calculate the number of days between the age of 2 person
	 */
	public static void days_older(Person p1, Person p2) {

		logger.info("Days older method\n");
		
		if(p1.getDate().isBefore(p2.getDate())) {
			System.out.println(p1.getName()+" is "+Days.daysBetween(p1.getDate(), p2.getDate()).getDays()+" days older than "+p2.getName());
		}
		else {
			System.out.println(p2.getName()+" is "+Days.daysBetween(p2.getDate(), p1.getDate()).getDays()+" days older than "+p1.getName());	
		}
		
	}
	  
	/*
	 * comparator
	 * Compare 2 Person type objects by date
	 */
	 static Comparator<Person> comparator = new Comparator<Person>() {
		    public int compare( Person a, Person b ) {
	
		    	return a.getDate().compareTo(b.getDate());
		    	
	       }
	  };    	
	
}



