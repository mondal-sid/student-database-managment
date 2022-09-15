<!DOCTYPE html>
<html lang="en">



    <body>
        
        <%
        if(session.getAttribute("username")==null)
        {
         %>
            <jsp:include page="index.jsp"></jsp:include>
        <%
        } 
        %>
        <table width="100%" height="100%">
            <tr height="20%">
                <td>
                    <%@ include file="home.jsp"%>
                </td>
            </tr>
            <tr height="80%">
                <td>
                    <div>
                        <h2><p align="center">Update Form</p></h2> 
                        <form action="./update.jsp" method="post">
                            <table align="center">
                                <tr>
                                    <td>Enter roll no </td>
                                    <td><input type="number" name ="roll"></td>
                                </tr>
                                <tr>
                                    <td>Enter updated name </td>
                                    <td><input type="text" name ="name"></td>
                                </tr>
                                <tr>
                                    <td>Enter updated Department</td>
                                    <td><input type="text" name="dept"></td>
                                </tr>
                                <tr>
                                    <td>Enter updated Address</td>
                                    <td><input type="text" name="address"></td>
                                </tr>
                                <tr>
                                    <td>Enter updated email id</td>
                                    <td><input type="text" name="email"></td>
                                </tr>
                                <tr>
                                    <td></td>
                                    <td>
                                        <button type="submit">Update</button>
                                        <button type="reset">Reset</button>
                                    </td>
                                </tr>
                            </table>
                        </form>
                    </div>
                </td>
            </tr>
        </table>
    </body>
</html>