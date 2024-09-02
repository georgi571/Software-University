SELECT
    id,
    CONCAT_WS(' ', c.first_name, c.last_name) AS `full_name`,
    c.ucn
FROM colonial_journey_management_system.colonists AS c
ORDER BY c.first_name, c.last_name, c.id;
