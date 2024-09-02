SELECT
    p.id,
    p.name,
    COUNT(*) AS `count`
FROM restaurant2.products AS p
    JOIN restaurant2.orders_products AS op ON p.id = op.product_id
GROUP BY p.id, p.name
HAVING count >= 5
ORDER BY count DESC, p.name;