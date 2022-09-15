package com.sidd.java;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;    
    
public class ConnectUserTest {

    @Before
    public void setup(){
        ConnectDb connObj = new ConnectDb("database-h2.properties");
        Connection conn = connObj.getConnection();
        String sql = "CREATE TABLE `student` (`roll_no` int DEFAULT NULL,`name` varchar(25) DEFAULT NULL,`Dept_name` varchar(20) DEFAULT NULL,`address` varchar(30) DEFAULT NULL,`email_id` varchar(30) DEFAULT NULL);";
        try {
            Statement statement = conn.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }       
    }

    @After
    public void destroy(){
        ConnectDb connObj = new ConnectDb("database-h2.properties");
        Connection conn = connObj.getConnection();
        String sql = "DROP TABLE student";
        try {
            Statement statement = conn.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }       
    }

    @Test
    public void testRegister() {
        Student s = new Student(1, "sid", "it", "abc", "bbbb");

        ConnectDb connObj = new ConnectDb("database-h2.properties");

        ConnectUser c = new ConnectUser();
        ConnectUser c1 = Mockito.spy(c);
        Mockito.doReturn(connObj).when(c1).getConnectionObject(); // here we calling the method of original class by mock object which return the value which we wanted 
        int status = c1.register(s);
        assertEquals(1, status);        
    }

    @Test
    public void testUpdate() {
        Student s = new Student(1, "sid", "it", "abc", "bbbb");
        Student s1 = new Student(1, "dis", "it", "abc", "bbbb");

        ConnectDb connObj = new ConnectDb("database-h2.properties");

        ConnectUser c = new ConnectUser();
        ConnectUser c1 = Mockito.spy(c);
        Mockito.doReturn(connObj).when(c1).getConnectionObject();
            c1.register(s);
            int status = c1.update(s1);    
        assertEquals(1, status); 
    }

    @Test
    public void testDelete() {
        Student s = new Student(1, "sid", "it", "abc", "bbbb");

        ConnectDb connObj = new ConnectDb("database-h2.properties");

        ConnectUser c = new ConnectUser();
        ConnectUser c1 = Mockito.spy(c);
        Mockito.doReturn(connObj).when(c1).getConnectionObject();
            c1.register(s);
            int status = c1.deleteStudent(s);    
        assertEquals(1, status); 
    }

    @Test
    public void testRetrive() {
        Student s1 = new Student(1, "sid", "it", "abc", "bbbb");

        List<Student> list = new ArrayList<Student>();

        list.add(s1);

        ConnectDb connObj = new ConnectDb("database-h2.properties");

        ConnectUser c = new ConnectUser();
        ConnectUser c1 = Mockito.spy(c);
        Mockito.doReturn(connObj).when(c1).getConnectionObject();
            c1.register(s1);
            List<Student> list2 = new ArrayList<Student>();
            list2 = c1.getAllRecords(null);    
        assertEquals(list.get(0).getRoll(), list2.get(0).getRoll()); 
    }
}
    