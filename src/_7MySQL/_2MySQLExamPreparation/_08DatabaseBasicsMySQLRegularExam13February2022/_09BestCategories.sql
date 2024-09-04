SELECT
    COUNT(*) AS `items_count`,
    c.name,
    SUM(p.quantity_in_stock) AS `total_quantity`
FROM online_store2.categories AS c
    LEFT JOIN online_store2.products p on c.id = p.category_id
GROUP BY c.name
ORDER BY items_count DESC, total_quantity
LIMIT 5;