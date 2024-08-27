SELECT
    e.employee_id,
    e.first_name,
    CASE
        WHEN YEAR(p.start_date) >= '2005' THEN NULL
        ELSE p.name
    END AS `project_name`
FROM soft_uni6.employees AS e
         JOIN soft_uni6.employees_projects AS ep ON e.employee_id = ep.employee_id
         JOIN soft_uni6.projects AS p ON ep.project_id = p.project_id
WHERE e.employee_id = 24
ORDER BY project_name;