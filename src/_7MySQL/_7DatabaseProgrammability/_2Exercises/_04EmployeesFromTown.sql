DELIMITER $$
CREATE PROCEDURE soft_uni8.usp_get_employees_from_town(`town_name` VARCHAR(255))
BEGIN
    SELECT
        first_name,
        last_name
    FROM soft_uni8.employees
             JOIN soft_uni8.addresses a on a.address_id = employees.address_id
             JOIN soft_uni8.towns t on t.town_id = a.town_id
    WHERE t.name = town_name
    ORDER BY first_name, last_name, employee_id;
END$$
DELIMITER ;