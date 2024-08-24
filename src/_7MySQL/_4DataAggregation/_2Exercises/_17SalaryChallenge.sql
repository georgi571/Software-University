SELECT
    first_name,
    last_name,
    department_id
FROM soft_uni4.employees
WHERE salary > (
    SELECT AVG(salary)
    FROM soft_uni4.employees AS e
    WHERE e.department_id = employees.department_id
)
GROUP BY department_id, employee_id
ORDER BY department_id, employee_id LIMIT 10;