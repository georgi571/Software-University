SELECT
    department_id,
    MIN(salary) AS `minimum_salary`
FROM soft_uni4.employees
WHERE hire_date > '2000-01-01'
GROUP BY department_id
HAVING department_id IN (2, 5, 7)
ORDER BY department_id;