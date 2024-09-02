SELECT
    p.id,
    CONCAT_WS(' ', p.first_name, p.last_name) AS `full_name`,
    p.age,
    p.position,
    p.hire_date
FROM fsd.players AS p
    JOIN fsd.skills_data AS sd ON sd.id = p.skills_data_id
WHERE p.age < 23 AND p.position = 'A' AND p.hire_date IS NULL AND sd.strength > 50
ORDER BY p.salary, p.age;