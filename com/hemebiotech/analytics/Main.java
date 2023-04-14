package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String args[]){
		// TODO Auto-generated method stub
    ISymptomReader readSymptoms = new ReadSymptomDataFromFile("symptoms.txt");
    ISymptomWriter writeSymptoms = new WriteSymptomDataToFile();
    AnalyticsCounter analytics = new AnalyticsCounter(readSymptoms, writeSymptoms);
    
    List<String> symptoms = analytics.getSymptoms();
    Map<String, Integer> countedSymptoms = analytics.countSymptoms(symptoms);
    Map<String, Integer> sortedSymptoms = analytics.sortSymptoms(countedSymptoms);
    analytics.writeSymptoms(sortedSymptoms);
	}
}

