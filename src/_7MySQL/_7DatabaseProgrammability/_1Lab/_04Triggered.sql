CREATE TABLE soft_uni7.deleted_employees (
    employee_id  INT PRIMARY KEY AUTO_INCREMENT,
    first_name   VARCHAR(50),
    last_name    VARCHAR(50),
    middle_name  VARCHAR(50),
    job_title    VARCHAR(50),
    department_id INT,
    salary       DECIMAL(19, 4)
);

DELIMITER $$
CREATE TRIGGER soft_uni7.tr_after_delete_employees
AFTER DELETE
ON soft_uni7.employees
FOR EACH ROW
BEGIN
    INSERT INTO soft_uni7.deleted_employees (first_name, last_name, middle_name, job_title, department_id, salary)
    VALUES (OLD.first_name,
            OLD.last_name,
            OLD.middle_name,
            OLD.job_title,
            OLD.department_id,
            OLD.salary);
END$$

DELIMITER ;