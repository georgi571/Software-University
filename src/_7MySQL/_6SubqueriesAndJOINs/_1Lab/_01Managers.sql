SELECT
    e.employee_id,
    CONCAT_WS(' ', e.first_name, e.last_name) AS `full_name`,
    d.department_id,
    d.name AS `department_name`
FROM soft_uni5.departments AS d
JOIN soft_uni5.employees AS e on d.manager_id = e.employee_id
ORDER BY e.employee_id LIMIT 5;
