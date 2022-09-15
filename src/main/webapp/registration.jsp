
<%@ include file="home.jsp"%>

<%@ page import="com.sidd.java.ConnectUser"%>
<jsp:useBean id="obj" class="com.sidd.java.Student"/>
<jsp:setProperty property="*" name="obj"/>
<%  
    ConnectUser c = new ConnectUser();
    int status = c.register(obj);
    if(status > 0){
        out.println("Your registration is successfully done.");
    } else if(status == -1) 
    out.println("Record not created. Please check the values entered");    
%>
