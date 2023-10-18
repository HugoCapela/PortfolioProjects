USE coffee_store;

select * from customers;

-- 1. From the products table, select the name and price of all products with a
-- coffee origin equal to Colombia or Indonesia. Ordered by name from A-Z
select name,price from products
where coffee_origin in ('Colombia', 'Indonesia')
order by name ASC;

-- 2. From the orders table, select all the orders from February 2017
-- for customers with id's of 2,4,6 or 8
select * from orders
where order_time between '2017-02-01' and '2017-02-28'
and customer_id IN (2,4,6,8);

-- 3. From the customers table, select the first name and phone number of all customers
-- who's last name contains the pattern 'ar'
select first_name,phone_number from customers
where last_name LIKE '%ar%';