DELETE e
FROM ruk.employees AS e
    LEFT JOIN ruk.employees_clients ec on e.id = ec.employee_id
WHERE ec.employee_id IS NULL;