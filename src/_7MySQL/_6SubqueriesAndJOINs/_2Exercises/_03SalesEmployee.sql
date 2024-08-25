SELECT
    e.employee_id,
    e.first_name,
    e.last_name,
    d.name
FROM soft_uni6.employees AS e
    JOIN soft_uni6.departments AS d on d.department_id = e.department_id
WHERE d.name = 'Sales'
ORDER BY e.employee_id DESC;