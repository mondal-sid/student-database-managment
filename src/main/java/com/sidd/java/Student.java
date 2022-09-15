package com.sidd.java;

public class Student {
    private int roll;
    private String name;
    private String dept;
    private String address;
    private String email;
    public Student(){

    }

    public Student(int rolll,String name, String dept, String address, String email){
        this.roll=rolll;
        this.name=name;
        this.address=address;
        this.dept=dept;
        this.email=email;
    }
    public void setRoll(int roll){
        this.roll=roll;
    }

    public void setName(String name){
        this.name=name;
    }

    public void setDept(String dept){
        this.dept=dept;
    }

    public void setAddress(String address){
        this.address=address;
    }

    public void setEmail(String email){
        this.email=email;
    }


    public int getRoll(){
        return roll;
    }

    public String getName(){
        return name;
    }

    public String getDept(){
        return dept;
    }

    public String getAddress(){
        return address;
    }
    
    public String getEmail(){
        return email;
    }
}