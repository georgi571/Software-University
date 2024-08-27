SELECT
    e.first_name,
    e.last_name,
    e.hire_date,
    d.name AS `dept_name`
FROM soft_uni6.employees AS e
      JOIN soft_uni6.departments AS d ON d.department_id = e.department_id
WHERE e.hire_date > '1999-01-01' AND d.name IN ('Sales', 'Finance')
ORDER BY e.hire_date;