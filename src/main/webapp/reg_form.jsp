
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
        <%
        if(session.getAttribute("username")==null)
        {
         %>
            <jsp:include page="index.jsp"></jsp:include>
        <%
        } 
        %>
<body>
    <table width="100%" height="100%">
        <tr height="20%">
            <td>
                <%@ include file="home.jsp"%>
            </td>
        </tr>

        <tr height="80%">
            <td>
                <div>
                    <p align="center">Registration Form</p>
                    <form action="./registration.jsp" method="post">
                        <table align="center" width="">
                            <tr>
                                <td>Enter Roll no </td>
                                <td><input type="number" name="roll" max = 2147483647></td>
                            </tr>
                            <tr>
                                <td>Enter your name </td>
                                <td><input type="text" name ="name" maxlength="50"></td>
                            </tr>
                            <tr>
                                <td>Enter Department</td>
                                <td><input type="text" name="dept" maxlength="50"></td>
                            </tr>
                            <tr>
                                <td>Enter Address</td>
                                <td><input type="text" name="address" maxlength="50"></td>
                            </tr>
                            <tr>
                                <td>Enter email id</td>
                                <td><input type="text" name="email" maxlength="50"></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td>
                                    <button type="submit">Submit</button>
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