<%@ include file="home.jsp"%>
<%@ page import="com.sidd.java.ConnectUser"%>
<jsp:useBean id="obj" class="com.sidd.java.Student"/>
<jsp:setProperty property="*" name="obj"/>
    <%
    ConnectUser c = new ConnectUser();
    int status = c.update(obj);
    if(status > 0){
        out.println("Your updation is successfully done.");
    }else if (status ==0){
        out.println("Record not found ");
    }else{
        out.println(" Record not found");
    }
    %>
