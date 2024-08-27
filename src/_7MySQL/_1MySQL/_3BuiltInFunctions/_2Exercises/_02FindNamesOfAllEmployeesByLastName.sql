SELECT
    first_name, last_name
FROM soft_uni3.employees
WHERE employees.last_name LIKE ('%ei%')
ORDER BY employee_id;