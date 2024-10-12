SELECT
    c.id,
    c.name
FROM summer_olympics.countries AS c
    LEFT JOIN summer_olympics.athletes AS a ON c.id = a.country_id
WHERE a.id IS NULL
ORDER BY c.name DESC
LIMIT 15;