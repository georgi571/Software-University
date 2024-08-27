SELECT
    e.employee_id,
    e.first_name
FROM soft_uni6.employees AS e
       LEFT JOIN soft_uni6.employees_projects AS ep ON e.employee_id = ep.employee_id
WHERE ep.project_id IS NULL
ORDER BY e.employee_id DESC LIMIT 3;