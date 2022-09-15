package com.sidd.java;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class PropertyFileLoader {

    private static final Logger logger = Logger.getLogger(PropertyFileLoader.class.getName());

    private static final PropertyFileLoader instance = new PropertyFileLoader();

    private Properties properties = null;
    
    private PropertyFileLoader() {

    }

    public static PropertyFileLoader getInstance() {
        return instance;
    }

    public Properties loadProperties(String fileName) {
        if(properties != null) return properties;

        try {
            properties = new Properties();
            //FileInputStream fis = new FileInputStream("resources/database.properties");
            properties.load(getClass().getClassLoader().getResourceAsStream(fileName));
        } catch(FileNotFoundException e){
            logger.error("Unable to create connection Properties file not found", e);
        }catch(IOException e){
            logger.error("Unable to create connection Properties file cant be loaded", e);
        }
        
        return properties;
    }
}
