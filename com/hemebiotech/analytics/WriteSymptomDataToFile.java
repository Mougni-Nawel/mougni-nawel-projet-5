package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;


public class WriteSymptomDataToFile implements ISymptomWriter {

@Override
	public void writeSymptoms(Map<String, Integer> symptoms) {
		// TODO Auto-generated method stub
		try {
			FileWriter writer = new FileWriter("result.out");
			symptoms.forEach((key, value) -> {
				try {
					writer.write(key+" : "+value+"\n");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
			// writer.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}