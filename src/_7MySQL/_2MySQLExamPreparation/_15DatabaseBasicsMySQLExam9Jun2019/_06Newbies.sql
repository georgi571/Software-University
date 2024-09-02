SELECT
    id,
    CONCAT_WS(' ', e.first_name, e.last_name) AS `full_name`,
    CONCAT('$', e.salary) AS `salary`,
    e.started_on
FROM ruk.employees AS e
WHERE e.salary >= 100000 AND e.started_on >= '2018-01-01'
ORDER BY e.salary DESC, id;