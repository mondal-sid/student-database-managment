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
                        <form action="./delete_data.jsp">
                            <table align="center">
                                <tr>
                                    <p>
                                        <td>Enter the roll_no of the student want to delete </td>
                                        <td><input type="number" name="roll"></td>
                                    </p>
                                </tr>
                                <tr>
                                    <td></td>
                                    <td>
                                        <button type="submit">Submit</button>
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