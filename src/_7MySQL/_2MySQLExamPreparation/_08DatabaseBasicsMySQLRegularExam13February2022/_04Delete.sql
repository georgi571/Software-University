DELETE c
FROM online_store2.customers AS c
LEFT JOIN online_store2.orders AS o on c.id = o.customer_id
WHERE o.customer_id IS NULL;