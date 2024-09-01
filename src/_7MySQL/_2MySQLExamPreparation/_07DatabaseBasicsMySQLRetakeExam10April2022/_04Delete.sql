DELETE c
FROM softuni_imdbs.countries AS c
LEFT JOIN softuni_imdbs.movies AS m ON c.id = m.country_id
WHERE m.country_id IS NULL;