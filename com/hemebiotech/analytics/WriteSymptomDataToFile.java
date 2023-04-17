package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;


public class WriteSymptomDataToFile implements ISymptomWriter {

  private String filepath;

  /**
  * Get the path to the file with symptoms through the constuct.
  * @param filepath a full or partial path to file
  */
  public WriteSymptomDataToFile(String filepath) {
    this.filepath = filepath;
  }

  /**
  * Open a new file and for every symptoms in the map, its will write it in this file.
  * @param symptoms completed of every times a symptom is called in the previous file
  */
  @Override
  public void writeSymptoms(Map<String, Integer> symptoms) {
    try {
      FileWriter writer = new FileWriter(filepath);
      symptoms.forEach((key, value) -> {
        try {
          writer.write(key + " : " + value + "\n");
        } catch (IOException e) {
          e.printStackTrace();
        }
      });
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

}