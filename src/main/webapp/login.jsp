
<%
String user_id = request.getParameter("user_id");
String pwd = request.getParameter("pwd");

    if(user_id.equals("Siddhartha") && pwd.equals("sid123")){
        request.getSession();
        session.setAttribute("username", user_id);
        response.sendRedirect("home.jsp");   
    }else{
        response.sendRedirect("index.jsp");  
    }
%>
