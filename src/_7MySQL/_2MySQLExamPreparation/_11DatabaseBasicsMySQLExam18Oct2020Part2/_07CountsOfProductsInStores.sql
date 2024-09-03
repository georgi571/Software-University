SELECT
    s.name,
    COUNT(p.id) AS `product_count`,
    ROUND(AVG(p.price),2) AS `avg`
FROM softuni_stores_system.stores AS s
    LEFT JOIN softuni_stores_system.products_stores AS ps ON s.id = ps.store_id
    LEFT JOIN softuni_stores_system.products AS p ON p.id = ps.product_id
GROUP BY s.id
ORDER BY product_count DESC, avg DESC, s.id;