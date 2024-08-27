DELIMITER $$
CREATE PROCEDURE soft_uni8.usp_get_employees_by_salary_level(`salary_level` VARCHAR(255))
BEGIN
    SELECT
        first_name,
        last_name
    FROM soft_uni8.employees
    WHERE soft_uni8.ufn_get_salary_level(salary) = salary_level
    ORDER BY first_name DESC, last_name DESC ;
END$$
DELIMITER ;