package com.cs310.fountainfinder.service;
import org.junit.Before;

import com.cs310.fountainfinder.client.FountainSerializable;
import com.cs310.fountainfinder.service.FountainRegistry;


public class registryToList {
	
	private FountainRegistry registry;

	public registryToList() {
    registry = FountainRegistry.getDefault();
	}
	
	public FountainSerializable[] gatAllFointains() {
	
		return registry.regsitryToList();
		}
}