package com.sidd.java;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;


public class ConnectDbTest{
    ConnectDb connectDb = new ConnectDb("database-h2.properties");
    Connection con = null;


    @Test
    public void getConnectionTest(){
        try{
        con=connectDb.getConnection();
        assertNotNull( "connection creation is not successfull.",con);
        }catch(Exception e){
        }finally{
            try{
                if(con!= null){
                    con.close();
                }
                }catch(SQLException e){
            }
        }
    }
}
