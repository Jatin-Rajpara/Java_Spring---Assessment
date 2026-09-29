<%@ page import="java.util.List" %>
<%@ page import="com.jatin.model.Order" %>

<html>
<head>
    <title>All Orders</title>
</head>
<body>

<h2>All Orders</h2>

<table border="1">

    <tr>
        <th>Order ID</th>
        <th>Customer Name</th>
        <th>Restaurant Name</th>
        <th>Total Amount</th>
        <th>Status</th>
    </tr>

    <%
        List<Order> orders =
            (List<Order>) request.getAttribute("orders");

        for (Order order : orders) {
    %>

    <tr>
        <td><%= order.getOrderId() %></td>
        <td><%= order.getCustomerName() %></td>
        <td><%= order.getRestaurantName() %></td>
        <td><%= order.getTotalAmount() %></td>
        <td><%= order.getStatus() %></td>
    </tr>

    <%
        }
    %>

</table>

</body>
</html>