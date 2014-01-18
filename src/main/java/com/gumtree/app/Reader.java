/**
 * @author Diego Salvado
 * @
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


import com.gumtree.config.ConfigFiles;
import com.gumtree.model.Person;



public class Reader 
{
	static Scanner sc;
	static Logger logger;

	public static void main( String[] args )
    {


		logger = LoggerFactory.getLogger(Reader.class);
		
		
    	try {
    	
    	 File f = getFile(ConfigFiles.FILE_ADDRESS);
    	
    	 List<Person> list = readFile(f);
    	 
    	} catch (NullPointerException e) {
			logger.info("File path: Null pointer");
		
    	} catch (ParseException e) {
			// TODO Auto-generated catch block
    		logger.info("Error parsing data from file");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			logger.info("Scanner: File not found");
		}
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

    
    private static List<Person> readFile(File f) throws ParseException, FileNotFoundException {
    	

  	  sc = new Scanner(f);
			
		  SimpleDateFormat format = new SimpleDateFormat("dd/MM/yy");
		  List<Person> list_person = new ArrayList<Person>();
		  
		  while(sc.hasNextLine()){
              String line = sc.nextLine();
              
              String[] details = line.split(",");
              String name = details[0];
              String gender = details[1];
              DateTime date = new DateTime(format.parse(details[2]));
               	                
              Person p = new Person(name,gender,date);
              list_person.add(p);
  	
		  }
  
		  return list_person;
		  
	}
    
}
