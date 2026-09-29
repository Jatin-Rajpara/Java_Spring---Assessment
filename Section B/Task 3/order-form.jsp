<html>
<head>
    <title>Place Order</title>
</head>
<body>

<h2>Place Order</h2>

<form action="orders" method="post">

    Order ID:
    <input type="number" name="orderId">
    <br><br>

    Customer Name:
    <input type="text" name="customerName">
    <br><br>

    Restaurant Name:
    <input type="text" name="restaurantName">
    <br><br>

    Total Amount:
    <input type="number" step="0.01" name="totalAmount">
    <br><br>

    Status:
    <select name="status">
        <option value="PENDING">PENDING</option>
        <option value="CONFIRMED">CONFIRMED</option>
        <option value="DELIVERED">DELIVERED</option>
    </select>

    <br><br>

    <button type="submit">Place Order</button>

</form>

<br>

<a href="orders">View All Orders</a>

</body>
</html>