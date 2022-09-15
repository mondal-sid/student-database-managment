<!DOCTYPE html>
<html lang="en" dir="ltr">
   <head>
      <meta charset="utf-8">
      <title>Responsive Navigation Menu</title>
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <title>Student Data managment</title>
      <link rel="stylesheet" href="style.css">
   </head>
   

   <body>
      <%
      if(session.getAttribute("username")==null)
      {
         response.sendRedirect("index.jsp");
      }
      %>
      <table width="100%" height="100%"></table>
         <ul>

            <li><a href="logout.jsp"> Logout </a></li>
            <li><a href="update_form.jsp"> Update </a></li>
            <li><a href="delete.jsp"> Delete </a></li>
            <li><a href="retrive.jsp"> Show all Data </a></li>
            <li><a href="reg_form.jsp"> Registration </a></li>
            
         </ul>
      </table>
   </body>
</html>