DELIMITER $$
CREATE PROCEDURE soft_uni8.usp_get_towns_starting_with(`string` VARCHAR(255))
BEGIN
    SELECT
        name AS 'town_name'
    FROM soft_uni8.towns
    WHERE towns.name LIKE CONCAT(string, '%')
    ORDER BY town_name;
END$$
DELIMITER ;