<%@ page import="java.util.ArrayList" %>

<html>
<head>
    <title>Food Cart</title>
</head>
<body>

<h2>My Food Cart</h2>

<table border="1">
    <tr>
        <th>Item</th>
    </tr>

    <%
        ArrayList<String> cart =
            (ArrayList<String>) session.getAttribute("cart");

        if (cart != null) {
            for (String item : cart) {
    %>

    <tr>
        <td><%= item %></td>
    </tr>

    <%
            }
        }
    %>

</table>

<br>

<form action="cart" method="post">
    <input type="hidden" name="action" value="clear">
    <button type="submit">Clear Cart</button>
</form>

</body>
</html>