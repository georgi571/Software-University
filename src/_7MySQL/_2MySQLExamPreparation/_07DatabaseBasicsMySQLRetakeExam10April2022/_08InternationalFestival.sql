SELECT
    c.name,
    COUNT(*) `movies_count`
FROM softuni_imdbs.countries AS c
    JOIN softuni_imdbs.movies AS m ON c.id = m.country_id
GROUP BY c.name
HAVING movies_count >= 7
ORDER BY c.name DESC ;