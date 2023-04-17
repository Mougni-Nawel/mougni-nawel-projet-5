package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

/** 
 * different methods based on different treatments of symptoms.
 * @author Mougni
 *
 */
public class AnalyticsCounter implements ISymptomReader {

  private ISymptomReader reader;
  private ISymptomWriter writer;

  /** 
   * constructor.
   * @param reader from the interface ISymptomReader
   * @param writer from the interface ISymptomWriter
   *
   */
  public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
    
    this.reader = reader;
    this.writer = writer;

  }

  /**
  * this method will ask to the user what is the symptoms and will register them in an array.
  * @return the list of symptoms
  */
  public List<String> getSymptoms() {
    return reader.getSymptoms();
  }

  /**
  * this method will count occurences of symptoms in file.
  * @param symptoms list of type String
  * @return the map of every times the symptoms from the list was in the file
  */
  public Map<String, Integer> countSymptoms(List<String> symptoms) {
    Map<String, Integer> map = new HashMap<String, Integer>();

    for (String symptom: symptoms) {

      if (map.containsKey(symptom)) {
        map.put(symptom, map.get(symptom) + 1);
      } else {
        map.put(symptom, 1);
      }

    }

    return map;
  }

  /**
  * sort symptoms into parameters in alphabetical order.
  * @param symptoms completed of every times a symptom is called in the previous file
  * @return the map sorted
  */
  public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
    TreeMap<String, Integer> sorted = new TreeMap<>();
    sorted.putAll(symptoms);
    return sorted;
  }

  /**
  * Open a new file and for every symptoms in the map, its will write it in this file.
  * @param symptoms sorted of symptoms
  */
  public void writeSymptoms(Map<String, Integer> symptoms) {
    writer.writeSymptoms(symptoms);
  }

}