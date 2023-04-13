package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;
import java.util.Map;
import java.util.Collections;
import java.util.HashMap;

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
    symptoms.entrySet().stream().sorted(Map.Entry.comparingByKey());
    return symptoms;
  }

public void writeSymptoms(Map<String, Integer> symptoms) {
    WriteSymptomDataToFile writeSymptoms = new WriteSymptomDataToFile();
    writeSymptoms.writeSymptoms(symptoms);
 }
	
	public static void main(String args[]) throws Exception {
		// first get input
		BufferedReader reader = new BufferedReader (new FileReader("symptoms.txt"));
		String line = reader.readLine();

		int i = 0;
		int headCount = 0;	// counts headaches
		while (line != null) {
			i++;
			System.out.println("symptom from file: " + line);
			if (line.equals("headache")) {
				headCount++;
				System.out.println("number of headaches: " + headCount);
			}
			else if (line.equals("rush")) {
				rashCount++;
			}
			else if (line.contains("pupils")) {
				pupilCount++;
			}

			line = reader.readLine();	// get another symptom
		}
		
		// next generate output
		FileWriter writer = new FileWriter ("result.out");
		writer.write("headache: " + headacheCount + "\n");
		writer.write("rash: " + rashCount + "\n");
		writer.write("dialated pupils: " + pupilCount + "\n");
		writer.close();
	}
}