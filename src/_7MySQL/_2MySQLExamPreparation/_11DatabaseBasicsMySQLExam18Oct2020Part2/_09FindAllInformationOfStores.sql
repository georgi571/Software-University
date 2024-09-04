SELECT
    REVERSE(s.name) AS `reversed_name`,
    CONCAT_WS('-', UPPER(t.name) , a.name) AS `full_address`,
    COUNT(e.id) AS `employees_count`
FROM softuni_stores_system.stores AS s
    LEFT JOIN softuni_stores_system.employees AS e ON s.id = e.store_id
    JOIN softuni_stores_system.addresses AS a ON a.id = s.address_id
    JOIN softuni_stores_system.towns AS t ON t.id = a.town_id
GROUP BY s.id
HAVING employees_count >= 1
ORDER BY full_address;
