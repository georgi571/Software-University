DELIMITER $$
CREATE PROCEDURE soft_uni8.usp_get_employees_from_town(`town_name` VARCHAR(255))
BEGIN
    SELECT
        e.first_name,
        e.last_name
    FROM soft_uni8.employees AS e
             JOIN soft_uni8.addresses AS a ON a.address_id = e.address_id
             JOIN soft_uni8.towns AS t ON t.town_id = a.town_id
    WHERE t.name = town_name
    ORDER BY e.first_name, e.last_name, e.employee_id;
END$$
DELIMITER ;