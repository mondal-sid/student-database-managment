
    <%
        request.getSession();
        session.removeAttribute("username");
        session.invalidate();

    %>
    <jsp:include page="index.jsp"></jsp:include>
