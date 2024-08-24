CREATE TABLE soft_uni4.highest_paid_employees
SELECT * FROM soft_uni4.employees
WHERE salary > 30000;

DELETE FROM soft_uni4.highest_paid_employees
WHERE manager_id = 42;

UPDATE soft_uni4.highest_paid_employees
SET salary = salary + 5000
WHERE department_id = 1;

SELECT
    department_id,
    AVG(salary) AS 'avg_salary'
FROM soft_uni4.highest_paid_employees
GROUP BY department_id
ORDER BY department_id;