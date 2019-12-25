package com.zeroBank.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

    private static Properties configFile;  // private Properties variable

    static {
        try {
            FileInputStream fileInputStream = new FileInputStream("configuration.properties");
            configFile = new Properties();
            configFile.load(fileInputStream);


        }catch (IOException e) {
            System.out.println("File was not loaded");
            e.printStackTrace(); // prints out the logs about the errors
        }
    }

    public static String getProperty(String key){
        return  configFile.getProperty(key);
    }

}
