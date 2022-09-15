package com.sidd.java;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.log4j.Logger;

public class ConnectUser{ 

    private static final Logger logger = Logger.getLogger(ConnectUser.class.getName());

    public ConnectDb getConnectionObject() {
        ConnectDb connectDb = new ConnectDb("database.properties");
        return connectDb;
    }

	public int register(Student s){
        int status=0;
        Connection con=null;
        if(s.getRoll()<=0) return -1;
        else{
            try {
				int reg_roll=s.getRoll();
                
                ConnectDb connectDb = getConnectionObject();
                con=connectDb.getConnection();

                logger.info("Connection created suceessfully to register student data ");
                PreparedStatement pr = con.prepareStatement("insert into student values(?,?,?,?,?);");
				pr.setInt(1, s.getRoll());
                pr.setString(2, s.getName());
                pr.setString(3, s.getDept());
                pr.setString(4, s.getAddress());
                pr.setString(5, s.getEmail());
                status = pr.executeUpdate();
                logger.info("Registration sucessfully done for roll no : " + reg_roll);
                pr.close();
                } catch (NumberFormatException ex) {
                    logger.error(ex.getMessage());
                    return -1;
                } catch (SQLException ex) {
                    logger.error(ex.getMessage());
                    return -1;
                }
                catch (Exception e) {
                    logger.error(e.getMessage());
                } 
                finally{
                    try{
                        if(con!=null){
                            con.close();
                        }
                    }catch(SQLException ex){
                    }        
                }
            return status;
        }      
	}
   
    public List<Student> getAllRecords(String roll){  
        List<Student> list=new ArrayList<Student>();  
        Connection con = null;
        try{  
            String sql = "";

            if(roll == null || roll.equals("")){
                sql = "select * from student";
            }
            else{
                sql = "select * from student where roll_no = " + roll;
            } 
                            
                ConnectDb connectDb = getConnectionObject();
                con=connectDb.getConnection();

            logger.info("Connection created suceessfully to get student data ");
            PreparedStatement ps=con.prepareStatement(sql);  
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
                Student s = new Student();  
                s.setRoll(rs.getInt(1));  
                s.setName(rs.getString(2));  
                s.setDept(rs.getString(3));
                s.setAddress(rs.getString(4)); 
                s.setEmail(rs.getString(5));  
                list.add(s);  
                Collections.sort(list, new SortByRoll());
            }   
        }
        catch(Exception e){
        }finally{
            try{
                if(con!= null){
                    con.close();
                }
            }catch(SQLException ex){
            }
        }
        
        return list;
    }  
    public int update(Student s) 
    {
        int status = 0;
        Connection con = null;;
        
        try {
            String sql="";
            sql="select count(*) from student where roll_no = " + String.valueOf(s.getRoll());
                            
                ConnectDb connectDb = getConnectionObject();
                con=connectDb.getConnection();
            logger.info("Connection created suceessfully to update student data ");
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs1=pst.executeQuery();
            if(rs1.next()){
            int update_roll=s.getRoll();
            PreparedStatement ps = con.prepareStatement("update Student set name=?,Dept_name=?,address=?,email_id=? where roll_no=?");
            ps.setString(1, s.getName());
            ps.setString(2, s.getDept());
            ps.setString(3, s.getAddress());
            ps.setString(4, s.getEmail());
			ps.setInt(5,s.getRoll());
            status = ps.executeUpdate();
            logger.info("Updation sucessfully done for roll no : " + update_roll); 
            ps.close();
            }else{
                return status;
            }
        } catch (NumberFormatException ex) {
            return -1;
        } catch (SQLException ex) {
            return -1;
        }catch (Exception e) {
        }finally{
            try {
                if (con!= null) {
                    con.close();                   
                }
            } catch (SQLException e) {
            }
        }
        return status;
    }

    public int deleteStudent(Student s){
        int status = 0;
        Connection con = null;
        try{
            String sql="";
            sql="select count(*) from student where roll_no = " + String.valueOf(s.getRoll());
                            
            ConnectDb connectDb = getConnectionObject();
            con=connectDb.getConnection();

            logger.info("Connection created suceessfully to delete student data ");
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs1=pst.executeQuery();
            if(rs1.next()){
                int delete_roll = s.getRoll();
                PreparedStatement ps=con.prepareStatement("delete from Student where roll_no=?");
                ps.setInt(1, s.getRoll());
                status = ps.executeUpdate();
                logger.info("Deletion sucessfully done for roll no : " + delete_roll); 
                ps.close();
            }
            rs1.close();
            pst.close();
        }catch (NumberFormatException ex) {
            return -1;
        } catch (SQLException ex) {
            return -1;
        }catch(Exception e){
        }finally{
            try {
                if (con!= null) {
                    con.close();                   
                }
            } catch (SQLException e) {
            }
        }
        return status;
    }
}

class SortByRoll implements Comparator<Student> {
    public int compare(Student a, Student b){
        return (a.getRoll()-b.getRoll());
    }
}