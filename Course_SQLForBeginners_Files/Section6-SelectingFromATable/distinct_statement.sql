USE coffee_store;

SELECT DISTINCT coffee_origin FROM products;

SELECT DISTINCT customer_id FROM orders
WHERE order_time BETWEEN '2017-02-01' AND '2017-02-28';

SELECT DISTINCT customer_id,product_id FROM orders
WHERE order_time BETWEEN '2017-02-01' AND '2017-02-28';