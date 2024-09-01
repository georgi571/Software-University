SELECT
    id,
    brand_id,
    name,
    quantity_in_stock
FROM online_store2.products
WHERE price > 1000 AND quantity_in_stock < 30
ORDER BY quantity_in_stock, id;