package de.dhbw.t2inf3001.pe;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class DataStore {

	public static List<String> read(String id) {
		List<String> result = new ArrayList<String>();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(DataStore.class.getResourceAsStream("datastore.csv")));
			String line = null;
			while ((line = br.readLine()) != null) {
				String[] tokens = line.split(";");
				String currentId = tokens[0].replaceAll("\"", "");
				if (currentId.equals(id)) {
					for (String token : tokens) {
						result.add(token.replaceAll("\"", ""));
					}
					return result;
				}
			}
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException(e);
		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					throw new Error(e);
				}
			}
		}
		return result;
	}
	
	public static void write(Student student) {
		FileWriter fw = null;
		BufferedWriter bw = null;
		
		try {
			fw = new FileWriter("datastore.csv", true);			
			bw = new BufferedWriter(fw);
			bw.write("test");
			bw.newLine();
			bw.close();
		}catch (FileNotFoundException e) {
			throw new IllegalArgumentException(e);
		}catch (IOException e) {
			throw new IllegalArgumentException(e);
		}finally {
			if(bw != null) {
				try {
					bw.close();
				}catch(IOException e) {
					throw new Error(e);
				}
			}
			if(fw != null) {
				try {
					fw.close();
				}catch(IOException e) {
					throw new Error(e);
				}
			}
		}
		
	}
}
