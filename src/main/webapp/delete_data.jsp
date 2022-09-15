<%@ include file="home.jsp"%>
<%@ page import="com.sidd.java.ConnectUser"%>
    <jsp:useBean id="s" class="com.sidd.java.Student"/>
    <jsp:setProperty property="*" name="s"/>
<%
    ConnectUser c = new ConnectUser();
    int status = c.deleteStudent(s);
    if(status > 0){
        out.println("Deletion is successfully done.");
    }else if (status == 0){
        out.println("No records found");
    } else   out.println("Data is not valid"); 
%>