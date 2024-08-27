SELECT
    department_id,
    SUM(salary) AS 'total_salary'
FROM soft_uni4.employees
GROUP BY department_id
ORDER BY department_id;