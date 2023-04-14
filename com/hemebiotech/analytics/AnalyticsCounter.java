package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class AnalyticsCounter implements ISymptomReader{
	private static int headacheCount = 0;	
	private static int rashCount = 0;		
	private static int pupilCount = 0;	
	private ISymptomReader reader;
	private ISymptomWriter writer;

	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		this.reader = reader;
		this.writer = writer;
	 }

public List<String> getSymptoms(){ 
	ReadSymptomDataFromFile readSymptom = new ReadSymptomDataFromFile("symptoms.txt");
	return readSymptom.getSymptoms();
}

public Map<String, Integer> countSymptoms(List<String> symptoms) {
    Map<String, Integer> map = new HashMap<String, Integer>();
		for(String symptom: symptoms) {
			if(map.containsKey(symptom)) {
				map.put(symptom, map.get(symptom)+1);
			}else {
				map.put(symptom, 1);
			}
		}
		return map;
 }

 public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
    TreeMap<String, Integer> sorted = new TreeMap<>();

    sorted.putAll(symptoms);

    return sorted;
  }

public void writeSymptoms(Map<String, Integer> symptoms) {
    WriteSymptomDataToFile writeSymptoms = new WriteSymptomDataToFile();
    writeSymptoms.writeSymptoms(symptoms);
 }
	
}