<%@ page import="jakarta.servlet.http.HttpSession" %>

<html>
<head>
    <title>Dashboard</title>
</head>
<body>

<%
    HttpSession session1 = request.getSession(false);

    if (session1 == null || session1.getAttribute("username") == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>

<h2>Food Delivery Dashboard</h2>

<h3>
    Welcome, <%= session1.getAttribute("username") %>
</h3>

<br>

<a href="restaurants">View Restaurants</a>

</body>
</html>