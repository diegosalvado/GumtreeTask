/**
 * @author Diego Salvado
 * 
 */

package com.gumtree.app;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import com.gumtree.config.Config;
import com.gumtree.model.Person;



public class Reader 
{
	static Scanner sc;
	static Logger logger;

	public static void main( String[] args )
    {

		logger = LoggerFactory.getLogger(Reader.class);
		
		System.out.println("Gumtree coding challenge\n");
		
		
    	try {
    	
    	 File f = getFile(Config.FILE_ADDRESS);
    	
    	 List<Person> list = readFile(f);
    	
    	 System.out.println("Number of males in list: "+Questions.number_males(list));
    	 
    	 System.out.println("The oldest person is: "+Questions.oldest(list));
    	 
    	 
    	 Person Bill = getPerson(list, Config.BILL);
    	 Person Paul = getPerson(list, Config.PAUL);
    	 
    	 Questions.days_older(Bill, Paul);
    	 		
    	 
    	} catch (NullPointerException e) {
			logger.error(Config.NULL_POINTER_EXCEPTION);
		
    	} catch (ParseException e) {
    		logger.error(Config.PARSER_EXCEPTION);
			
		} catch (FileNotFoundException e) {
			logger.error(Config.FILE_NOT_FOUND_EXCEPTION);
		}
    }

    
	/*
	 * @param List<Person>, String
	 * @return Person
	 * if there is a person in the list with the name equals to the input parameter, return Person
	 * else return null
	 */
	public static Person getPerson(List<Person> list, String name) {
		
		for(Person p:list) {
			if(p.getName().equals(name)) return p;
		}
		return null;
	}
	
	/*
	 * @param filepath
	 * @return File
	 * get File from the path indicated as param. If there is no file, throw Exception
	 */
    public static File getFile(String filepath) throws NullPointerException {
    	URL url = Reader.class.getResource(filepath);
    	return new File(url.getPath());
    }

    /*
	 * @param File
	 * @return List<Person>
	 * read the file and parse the data(name,gender,age) in a list of Person objects
	 */
    public static List<Person> readFile(File f) throws ParseException, FileNotFoundException {
    	

  	  sc = new Scanner(f);
			
		  SimpleDateFormat format = new SimpleDateFormat(Config.DATE_FORMAT);
		  List<Person> list_person = new ArrayList<Person>();
		  
		  while(sc.hasNextLine()){
              String line = sc.nextLine();
              
              String[] details = line.split(Config.SEPARATOR);
              String name = details[0];
              String gender = details[1].replace(" ","");
              DateTime date = new DateTime(format.parse(details[2]));
               	                
              Person p = new Person(name,gender,date);
              list_person.add(p);
  	
		  }
  
		  return list_person;
		  
	}
    
}
