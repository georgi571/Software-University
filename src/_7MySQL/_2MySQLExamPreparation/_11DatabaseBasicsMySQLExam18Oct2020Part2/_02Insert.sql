INSERT INTO softuni_stores_system.products_stores(product_id, store_id)
SELECT
    p.id,
    1
FROM softuni_stores_system.products AS p
    LEFT JOIN softuni_stores_system.products_stores AS ps ON p.id = ps.product_id
WHERE ps.product_id IS NULL;