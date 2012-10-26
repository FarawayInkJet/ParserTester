package com.cs310.fountainfinder.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class FountainRegistry {
	List<Fountains> myFountains = new ArrayList<Fountains>();
	
	/**
	 * Static default instance
	 */
	
	private static FountainRegistry defaultInstance = createDefaultInstance();

	public static FountainRegistry getDefault() {
		return defaultInstance;
		
	}
	
	/**
	 * Creates a default FountainRegistry Instance that 
	 *  is made by the parsing of the KML
	 */
	private static FountainRegistry createDefaultInstance() {
		FountainRegistry made = new FountainRegistry();
		 
		// Calling Parser
		SAXParserFactory factory = SAXParserFactory.newInstance();
		try {
			SAXParser saxParser = factory.newSAXParser();
			saxParser.parse(new File ("drinkingFountains.kml"), new FountainParser(made));
		} catch (Throwable error) {
			error.printStackTrace();
		}
		return made;
	}


	public void addFountain(Fountains currentFountain) {
		myFountains.add(currentFountain);
		
	}
	
	public Fountains lookupByID(String ID) {
		for (Fountains f: myFountains) {
			if(f.getId().equals(ID)) {
				return f;
			}
		}
		return null;
	}
	
	
	
}
