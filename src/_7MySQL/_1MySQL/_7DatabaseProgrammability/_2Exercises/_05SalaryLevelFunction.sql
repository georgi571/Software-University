DELIMITER $$
CREATE FUNCTION soft_uni8.ufn_get_salary_level(`salary` DECIMAL(19, 2))
    RETURNS VARCHAR(255)
    DETERMINISTIC
BEGIN
    RETURN (
        SELECT
        CASE
            WHEN salary < 30000 THEN 'Low'
            WHEN salary <= 50000 THEN 'Average'
            WHEN salary > 50000 THEN 'High'
        END AS `salary_level`
    );
END$$
DELIMITER ;