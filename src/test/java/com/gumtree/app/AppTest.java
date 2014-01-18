package com.gumtree.app;


import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.List;

import com.gumtree.config.ConfigFiles;
import com.gumtree.model.Person;


import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     * @throws ParseException 
     * @throws FileNotFoundException 
     */
    public void testApp() throws FileNotFoundException, ParseException
    {
    	  //true if file not null 
        assertNotNull(Reader.getFile(ConfigFiles.FILE_ADDRESS));
        
        File f = Reader.getFile(ConfigFiles.FILE_ADDRESS);
        
        List<Person> list = Reader.readFile(f);
        assertNotNull(list);
        
        for(Person p:list)
 			  System.out.println(p.toString()); 
        
        assertEquals(3, Questions.number_males(list));
        
    }
}
