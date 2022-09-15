<%@ include file="home.jsp"%>
<%@ page import="com.sidd.java.ConnectUser, com.sidd.java.Student, java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

  
<%  

    ConnectUser c = new ConnectUser();

    String roll_no = request.getParameter("roll_no");
    
    List<Student> list = c.getAllRecords(roll_no);
   
    request.setAttribute("list",list);
%>  
  
<table border="1" align="center">  
    <div>
        <h2 align="center">Student List <h2>
        <tr>
            <th>Roll no </th><th>Name</th><th>Department </th><th>Address</th><th>Email</th>
        </tr>  
        <c:forEach items="${list}" var="s">  
            <tr>
                <td>${s.getRoll()}</td><td>${s.getName()}</td><td>${s.getDept()}</td><td>${s.getAddress()}</td><td>${s.getEmail()}</td>
            </tr> 
        </c:forEach>  
    </div>
</table>  
