SELECT
    employee_id,
    first_name,
    last_name,
    department_id,
    salary
FROM soft_uni5.employees
WHERE manager_id IS NULL;