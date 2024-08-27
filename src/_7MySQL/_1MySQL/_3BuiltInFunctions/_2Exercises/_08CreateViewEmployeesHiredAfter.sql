CREATE VIEW soft_uni3.v_employees_hired_after_2000 AS
SELECT first_name, last_name
FROM soft_uni3.employees
WHERE YEAR(hire_date) > 2000;

SELECT * FROM soft_uni3.v_employees_hired_after_2000;