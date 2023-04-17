package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

/**
* Main class.
* @author Mougni
*
*/

public class Main {

  /**
  * Main method call all the methods.
  * @param args The command line arguments.
  */
  public static void main(String[] args) {
    ISymptomReader readSymptoms = new ReadSymptomDataFromFile("symptoms.txt");
    ISymptomWriter writeSymptoms = new WriteSymptomDataToFile("result.out");
    AnalyticsCounter analytics = new AnalyticsCounter(readSymptoms, writeSymptoms);

    List<String> symptoms = analytics.getSymptoms();
    Map<String, Integer> countedSymptoms = analytics.countSymptoms(symptoms);
    Map<String, Integer> sortedSymptoms = analytics.sortSymptoms(countedSymptoms);
    analytics.writeSymptoms(sortedSymptoms);

  }

}

