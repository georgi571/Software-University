DELIMITER $$
CREATE PROCEDURE soft_uni8.usp_get_employees_salary_above(`salary` DECIMAL(19,4))
BEGIN
    SELECT
        first_name,
        last_name
    FROM soft_uni8.employees
    WHERE employees.salary >= salary
    ORDER BY first_name, last_name, employee_id;
END$$
DELIMITER ;