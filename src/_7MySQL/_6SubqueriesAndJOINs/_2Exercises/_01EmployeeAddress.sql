SELECT
    e.employee_id,
    e.job_title,
    e.address_id,
    a.address_text
FROM soft_uni6.employees AS e
JOIN soft_uni6.addresses AS a ON a.address_id = e.address_id
ORDER BY a.address_id LIMIT 5;