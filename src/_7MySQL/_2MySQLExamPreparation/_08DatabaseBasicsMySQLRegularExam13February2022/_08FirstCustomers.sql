SELECT
    CONCAT_WS(' ', c.first_name, c.last_name) AS `full_name`,
    c.address,
    o.order_datetime
FROM online_store2.customers AS c
    JOIN online_store2.orders AS o ON c.id = o.customer_id
WHERE YEAR(o.order_datetime) <= 2018
ORDER BY full_name DESC;