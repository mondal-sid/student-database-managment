package com.sidd.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.log4j.Logger;


public class ConnectDb{
    private static final Logger logger = Logger.getLogger(ConnectDb.class.getName());

    private String fileName = "";

    public ConnectDb(String fileName) {   
        this.fileName = fileName;     
    }
    
    public Connection getConnection(){
        Connection conn=null;               
            try
            {
                Properties properties = PropertyFileLoader.getInstance().loadProperties(fileName);

                String dbname = (String) properties.get("dbname");
                String url = (String) properties.get("url");
                String user = (String) properties.get("user");
                String password = (String) properties.get("password");
				Class.forName(dbname);
                conn = DriverManager.getConnection(url, user, password);
            }catch(ClassNotFoundException e){
                logger.error("Unable to create connection Driver not found", e);
            }catch(SQLException e){
                logger.error("Unable to create connection ", e);
            }  
            
    return conn;
    }
}

