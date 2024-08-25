SELECT
    e.employee_id,
    e.first_name,
    e.salary,
    d.name
FROM soft_uni6.employees AS e
         JOIN soft_uni6.departments AS d on d.department_id = e.department_id
WHERE e.salary > 15000
ORDER BY d.department_id DESC LIMIT 5;