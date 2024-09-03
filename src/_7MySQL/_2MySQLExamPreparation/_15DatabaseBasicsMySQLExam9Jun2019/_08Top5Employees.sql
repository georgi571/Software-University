SELECT
    CONCAT_WS(' ', e.first_name, e.last_name) AS `name`,
    e.started_on,
    COUNT(ec.employee_id) AS `count_of_clients`
FROM ruk.employees AS e
    JOIN ruk.employees_clients AS ec ON e.id = ec.employee_id
GROUP BY e.id
ORDER BY count_of_clients DESC, e.id
LIMIT 5;