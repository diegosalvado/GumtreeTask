/**
 * @author Diego Salvado
 * 
 */

package com.gumtree.app;


import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.List;

import com.gumtree.config.Config;
import com.gumtree.model.Person;


import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class ReaderTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public ReaderTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( ReaderTest.class );
    }

    /**
     * Rigourous Test :-)
     * @throws ParseException 
     * @throws FileNotFoundException 
     */
    public void testApp() throws FileNotFoundException, ParseException, NullPointerException
    {
    	
    	System.out.println("-- Test Methods --");
    	
        assertNotNull(Reader.getFile(Config.FILE_ADDRESS));
        
        File f = Reader.getFile(Config.FILE_ADDRESS);
        
        List<Person> list = Reader.readFile(f);
        assertNotNull(list);
                
        assertEquals(3, Questions.number_males(list));
        
        assertEquals("Wes Jackson", Questions.oldest(list).getName());
        
        Person p1 = list.get(1); //Paul
        Person p2 = list.get(2); //Gemma
        
        Questions.days_older(p1, p2);       
        
        System.out.println("-- Test Methods Completed --\n");        
    }
    
    public void testError() throws FileNotFoundException, ParseException
    {
    	
    	 System.out.println("-- Test Errors --");
    	
    	 String wrong_file_path = "/com/gumtree/wrongfile/AddressBook";
    	 
    	 try {
    		 assertNull(Reader.getFile(wrong_file_path));
    	
    	 } catch (NullPointerException e) {
		     System.out.println("Wrong file path");
		 }
    	
    	 List<Person> list = null;
    	
    	 try {
    	 
    		 assertNull(Questions.number_males(list));
    	 
    	 } catch (NullPointerException e) {
			
    		 System.out.println("Null list");
		} 
    	 
    	 
    	 System.out.println("-- Test Errors Completed --\n");   
    	
    }
    
}
