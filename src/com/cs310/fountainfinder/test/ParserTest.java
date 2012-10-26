package com.cs310.fountainfinder.test;



import com.cs310.fountainfinder.service.FountainRegistry;
import com.cs310.fountainfinder.service.Fountains;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ParserTest {
	// Registry to test
	private FountainRegistry registry;
	
	@Before
	public void setUp() {
		registry = FountainRegistry.getDefault();
		System.out.println("set up");
	}
	@Test
	public void testlookupPoint() {
		// Form input
		Fountains f = registry.lookupByID("kml_2");
		System.out.println("made f");
		System.out.println(f.getId());
		assertEquals(f.getId(), "kml_2");
		assertEquals(String.valueOf(f.getLat()), String.valueOf(-123.024141));
		assertEquals(String.valueOf(f.getLng()), String.valueOf(49.2758579999959));
	}
	

}

