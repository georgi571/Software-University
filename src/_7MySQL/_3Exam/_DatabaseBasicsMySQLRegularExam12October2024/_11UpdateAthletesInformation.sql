DELIMITER $$
CREATE PROCEDURE summer_olympics.udp_first_name_to_upper_case(letter CHAR(1))
BEGIN
    UPDATE summer_olympics.athletes
    SET first_name = UPPER(first_name)
    WHERE first_name LIKE CONCAT('%', `letter`);
END$$
DELIMITER ;


