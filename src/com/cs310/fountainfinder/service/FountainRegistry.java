package com.cs310.fountainfinder.service;
import java.io.File;



import java.util.ArrayList;
import java.util.List;



import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;


import com.cs310.fountainfinder.client.FountainSerializable;


public class FountainRegistry {
	List<FountainSerializable> myFountains = new ArrayList<FountainSerializable>();

	

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

		String[] n = {"A"};
		
//		DownloadFile.main(null);
//		MyUnzipUtil.main(n);
		

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



	public void addFountain(FountainSerializable currentFountain) {
		myFountains.add(currentFountain);
	}
	public FountainSerializable lookupByID(String ID) {
		for (FountainSerializable f: myFountains) {
			if(f.getId().equals(ID)) {
				return f;
			}
		}
		return null;
	}
	
	public int fountainLength() {
		return myFountains.size();
	}
	
	public FountainSerializable getFountain(int f) {
		return myFountains.get(f);
	}
	
	public FountainSerializable[] regsitryToList() {
		FountainSerializable[] input_fountains = new FountainSerializable[200];
			
		for (int i = 0; i < 167; i++) {
			input_fountains[i] = getFountain(i);
				
		}
		return input_fountains;
}
}