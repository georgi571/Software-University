SELECT
    p.name,
    p.price,
    p.best_before,
    CONCAT(LEFT(p.description, 10), '...') AS `short_description`,
    p2.url
FROM softuni_stores_system.products AS p
    JOIN softuni_stores_system.pictures AS p2 ON p2.id = p.picture_id
WHERE CHAR_LENGTH(p.description) > 100 AND YEAR(p2.added_on) < 2019 AND p.price > 20
ORDER BY p.price DESC;