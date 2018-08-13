package com.automation.maven.resources;

import java.io.*;
import java.util.Properties;

public class ReadDataProperty {
    /*
     * This is class for reading the property file data
     * the property file is present at the location mentioned in class loader
     */
    InputStream inputStream;

    public Properties getObjectRepository() throws IOException{
        Properties prop = new Properties();
        try {
            String propFileName = "PropertyFile.properties";
            
            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }

        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            inputStream.close();
        }
        return prop;
    }
    }
