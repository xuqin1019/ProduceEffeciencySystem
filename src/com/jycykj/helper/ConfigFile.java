package com.jycykj.helper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

//this class is used to deal with configuration file

public class ConfigFile {
    public static String getConfig(String path, String section) {
        section = "[" + section + "]";
        BufferedReader bufferedReader = null;
        try {
        	bufferedReader = new BufferedReader(new FileReader(path));
        	String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                line = line.trim();
                if (line.startsWith("#"))
                	continue;
                
                if (section.equalsIgnoreCase(line)) {
                    while ((line = bufferedReader.readLine()) != null) {
                        line = line.trim();
                        if (line.startsWith("#"))
                        	continue;
                        if (line.startsWith("[") == true)
                            return null;
                        if (line.length() > 0)
                            return line;
                    }
                }
            }
            return null;
        }
        catch (IOException e) {
        	e.printStackTrace();
        	return "";
        }
        finally {
			try {
	        	if (bufferedReader != null)
	        		bufferedReader.close();
			} catch (IOException e) {}
        }
    }

    public static ArrayList<String> getConfigs(String path, String section) {
        ArrayList<String> al = new ArrayList<String>();
        section = "[" + section + "]";
        BufferedReader bufferedReader = null;
        try {
        	bufferedReader = new BufferedReader(new FileReader(path));
        	String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                line = line.trim();
                if (line.startsWith("#"))
                	continue;
                
                if (section.equalsIgnoreCase(line)) {
                    while ((line = bufferedReader.readLine()) != null) {
                        line = line.trim();
                        if (line.startsWith("#"))
                        	continue;
                        if (line.startsWith("[") == true)
                            break;
                        if (line.length() > 0)
                            al.add(line);
                    }
                }
            }
            return al;
        }
        catch (IOException e) {
        	e.printStackTrace();
        	return al;
        }
        finally {
			try {
	        	if (bufferedReader != null)
	        		bufferedReader.close();
			} catch (IOException e) {}
        }
    }
    
}