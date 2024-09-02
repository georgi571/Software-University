SELECT
    t.id,
    t.capacity,
    COUNT(oc.client_id) AS count_clients,
    CASE
        WHEN COUNT(oc.client_id) < t.capacity THEN 'Free seats'
        WHEN COUNT(oc.client_id) = t.capacity THEN 'Full'
        ELSE 'Extra seats'
    END AS availability
FROM restaurant2.tables AS t
    JOIN restaurant2.orders AS o ON t.id = o.table_id
    JOIN restaurant2.orders_clients AS oc ON o.id = oc.order_id
WHERE t.floor = 1
GROUP BY t.id, t.capacity
ORDER BY t.id DESC;