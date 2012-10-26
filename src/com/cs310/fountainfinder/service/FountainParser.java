package com.cs310.fountainfinder.service;


import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


/**
 * Imports KML file as Fountains
 */
public class FountainParser extends DefaultHandler {

	boolean id = false;
	boolean Coordinates = false;
	boolean Location = false;
	boolean Status = false;
	boolean Maintainer = false;
	private FountainRegistry FountainRegistry;
	private Fountains currentFountain;
	private String currentLocation;
	private String currentLatLong;
	private String currentStatus;

	private String currentMaintainer;
	
	
	  
	
	
	public FountainParser(FountainRegistry reg) {
		FountainRegistry = reg;
	}
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if (qName.equalsIgnoreCase("Placemark")) {
			currentFountain = new Fountains(attributes.getValue("id"));
			// System.out.println(attributes.getValue("id"));  works
		}
		else if (qName.equalsIgnoreCase("coordinates")) {
			Coordinates = true;
		}
		else if (qName.equalsIgnoreCase("SimpleData")) {
			// System.out.println(attributes.getValue("name")); works
			String val = attributes.getValue("name");
			if(val.equalsIgnoreCase("Location"))
				Location = true; 
			else if(val.equalsIgnoreCase("Status"))
				Status = true;
			else if(val.equalsIgnoreCase("maintainer"))
				Maintainer = true;
		}
	}
	
	@Override
	public void endElement(String uri, String LocalName, String qName) {
		if (qName.equalsIgnoreCase("Placemark")) {
			currentFountain.setLatLong(currentLatLong);
			currentFountain.setLocation(currentLocation);
			currentFountain.setStatus(currentStatus);
			currentFountain.setMaintainer(currentMaintainer);
			FountainRegistry.addFountain(currentFountain);
		}
	}
	
	@Override
	public void characters(char ch[], int start, int length) {
		if (Coordinates) {
			currentLatLong = new String(ch, start, length);
			// System.out.println(currentLatLong); // The are printing out correctly
			Coordinates = false;
		}
		else if (Location) {
			currentLocation = new String(ch, start, length);
			// System.out.println(currentLocation); works
			Location = false;
		}
		else if (Status) {
			currentStatus = new String(ch, start, length);
			// System.out.println(currentStatus); works
			Status = false;
		}
		else if (Maintainer) {
			currentMaintainer = new String(ch, start, length);
			// System.out.println(currentMaintainer); works
			Maintainer = false;
		}
	}

	
	

}
