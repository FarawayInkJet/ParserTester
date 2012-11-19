package com.cs310.fountainfinder.test;

import com.cs310.fountainfinder.service.FountainRegistry;
import com.cs310.fountainfinder.service.registryToList;
import com.cs310.fountainfinder.client.FountainSerializable;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class registryToListTest {
		// Registry to test
		private FountainRegistry registry = FountainRegistry.getDefault();
		private FountainSerializable[] fountains = new FountainSerializable[200]; 
		private registryToList tolist = new registryToList();
		
		
		@Before
		public void setUp() {
			 System.out.println(fountains.length);
			 fountains = tolist.gatAllFointains();
			
//			FountainSerializable[] input_fountains = new FountainSerializable[200];
//					
//			for (int i = 0; i < 167; i++) {
//				input_fountains[i] = registry.getFountain(i);
//						
//			}
//			fountains = input_fountains;
//			System.out.println(fountains.length);
			 		}
		@Test
		public void testlookupPoint() {
			// Form input
		
			FountainSerializable f = fountains[1];
			// System.out.println("made f");
			// System.out.println(f.getId());
			assertEquals(f.getId(), "kml_2");
			assertEquals(String.valueOf(f.getLat()), String.valueOf(-123.024141));
			assertEquals(String.valueOf(f.getLng()), String.valueOf(49.2758579999959));
		}
}
