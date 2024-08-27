SELECT
    department_id,
    (SELECT DISTINCT e.salary
     FROM soft_uni4.employees AS e
     WHERE e.department_id = employees.department_id
     ORDER BY e.salary DESC
     LIMIT 1 OFFSET 2) AS 'third_highest_salary'
FROM soft_uni4.employees
GROUP BY department_id
HAVING third_highest_salary IS NOT NULL
ORDER BY department_id;