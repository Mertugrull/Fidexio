package com.cydeo.fidexio.utulities;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

    //1-Create a object of Properties class from Java library
    private static Properties properties = new Properties();
    //2-We need to open the file in java memory: FileInputStream

    static {

        FileInputStream file = null;
        try {
            file = new FileInputStream("configuration.properties");
            //3-Load the properties object using FileInputStream object
            properties.load(file);

            file.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String keyword) {

        return properties.getProperty(keyword);

    }
}


