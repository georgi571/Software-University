UPDATE restaurant2.orders
SET table_id = table_id - 1
WHERE id BETWEEN 12 AND 23;