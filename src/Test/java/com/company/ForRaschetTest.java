package com.company;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
public class ForRaschetTest {

	

	@Test
	public void testRas() {
		Map<String, Integer> myMap = new HashMap<String, Integer>() {{ //купончики
			  put("500", 500);
			  put("1000", 1000);
			  put("Ananas",1000);
			  }};	
		int x = 500; 
		
		assertNotNull(x);
	}

}
