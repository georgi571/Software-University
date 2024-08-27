DELIMITER $$
CREATE FUNCTION soft_uni7.ufn_count_employees_by_town(`town_name` VARCHAR(50))
RETURNS INT
DETERMINISTIC
BEGIN
    RETURN (
        SELECT COUNT(*)
        FROM employees AS e
            JOIN soft_uni7.addresses AS a ON e.address_id = a.address_id
            JOIN soft_uni7.towns t on t.town_id = a.town_id
        WHERE t.name = town_name
        );
END$$
DELIMITER ;