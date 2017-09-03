/*
Google Applied CS with Android Unit 1 Lesson 2

Program that takes in a three-letter country code and will return the full name
of the country to which it belongs. If the input is greater than 3 letters, 
considered the name of a country, and return the three-letter code for it. 

Created by Sabrina Ma on 9/3/17.
*/
package googleappliedcs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Country {
	
	HashMap<String, String> countries = new HashMap<String, String>();
	
	void insert(String line) {
		String[] splitLine = line.split("\\t");
		countries.put(splitLine[2], splitLine[0]);
	}
	
	String getCountryName(String code) {
		if (countries.containsKey(code)) {
			return countries.get(code);
		}
		return "Not a valid country code.";
	}
	
	String getCountryCode(String name) {
		if (countries.containsValue(name)) {
			for (Map.Entry<String, String> en : countries.entrySet()) {
				if (en.getValue().equals(name)) {
					return en.getKey();
				}
			}
		}
		return "Not a valid country name.";
	}
	
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(new File("countrydata.txt"));
		Country c = new Country();
		s.nextLine();
		while (s.hasNextLine()) {
			c.insert(s.nextLine());	
		}
		System.out.println(c.getCountryName("BDI"));
		System.out.println(c.getCountryName("abcd"));
		System.out.println(c.getCountryCode("Western Sahara"));
		System.out.println(c.getCountryCode("abcd"));
	}
}
