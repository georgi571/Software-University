DELIMITER $$
CREATE PROCEDURE soft_uni8.usp_get_employees_salary_above_35000()
BEGIN
    SELECT
        first_name,
        last_name
    FROM soft_uni8.employees
    WHERE salary > 35000
    ORDER BY first_name, last_name, employee_id;
END$$
DELIMITER ;
