SELECT
    CONCAT_WS(' ', e.first_name, e.last_name) AS `full_name`,
    s.name,
    a.name,
    e.salary
FROM softuni_stores_system.employees AS e
    JOIN softuni_stores_system.stores AS s ON s.id = e.store_id
    JOIN softuni_stores_system.addresses AS a ON a.id = s.address_id
WHERE
    e.salary < 4000 AND
    a.name LIKE ('%5%') AND
    CHAR_LENGTH(a.name) > 8 AND
    e.last_name LIKE ('%n');