CREATE TABLE food_orders (
    id INT PRIMARY KEY AUTO_INCREMENT,
    restaurant_id INT,
    item_name VARCHAR(100),
    quantity INT,
    customer_name VARCHAR(100)
);