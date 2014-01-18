/**
 * @author Diego Salvado
 * @
 */

package com.gumtree.app;

import java.io.File;
import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import com.gumtree.config.ConfigFiles;



public class Reader 
{

	public static void main( String[] args )
    {


		Logger logger = LoggerFactory.getLogger(Reader.class);
		
		
    	try {
    	
    	 File f = getFile(ConfigFiles.FILE_ADDRESS);
    	
    	 
    	} catch (NullPointerException e) {
			logger.info("File not found");
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
    
    
}
