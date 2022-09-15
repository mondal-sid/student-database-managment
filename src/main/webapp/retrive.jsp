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
                        <form action="./retrive_data.jsp">
                            <label for="roll_no">Roll No :</label><br>
                            <input type="text" id="Roll" name="roll_no">
                            <button type="submit"> submit</button>
                        </form>
                    </div>
                </td>
            </tr>
        </table>
    </body>
</html>