<%@ page import="java.util.List" %>
<%@ page import="com.jatin.model.Restaurant" %>
<%@ page import="com.jatin.model.MenuItem" %>

<html>
<head>
    <title>Restaurants</title>
</head>
<body>

<h2>Restaurants and Menu</h2>

<table border="1">

    <tr>
        <th>Restaurant</th>
        <th>City</th>
        <th>Menu Item</th>
        <th>Price</th>
    </tr>

    <%
        List<Restaurant> restaurants =
            (List<Restaurant>) request.getAttribute("restaurants");

        for (Restaurant restaurant : restaurants) {

            for (MenuItem item : restaurant.getMenuItems()) {
    %>

    <tr>
        <td><%= restaurant.getName() %></td>
        <td><%= restaurant.getCity() %></td>
        <td><%= item.getItemName() %></td>
        <td><%= item.getPrice() %></td>
    </tr>

    <%
            }
        }
    %>

</table>

</body>
</html>