SELECT
    e.employee_id,
    CONCAT_WS(' ', e.first_name, e.last_name) AS `employee_name`,
    CONCAT_WS(' ', m.first_name, m.last_name) AS `manager_name`,
    d.name AS `department_name`
FROM soft_uni6.employees AS e
    JOIN soft_uni6.employees AS m ON e.manager_id = m.employee_id
    JOIN soft_uni6.departments d on d.department_id = e.department_id
WHERE e.manager_id IS NOT NULL
ORDER BY e.employee_id LIMIT 5;