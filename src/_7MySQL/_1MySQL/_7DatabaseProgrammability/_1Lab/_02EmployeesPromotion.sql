DELIMITER $$
CREATE PROCEDURE soft_uni7.usp_raise_salaries(`department_name` VARCHAR(50))
BEGIN
    UPDATE soft_uni7.employees AS e
        JOIN soft_uni7.departments AS d ON e.department_id = d.department_id
    SET e.salary = e.salary * 1.05
    WHERE d.name = department_name;
END$$
DELIMITER ;

