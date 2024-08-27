SELECT
    c.country_name,
    r.river_name
FROM geography4.countries AS c
    LEFT JOIN geography4.countries_rivers cr on c.country_code = cr.country_code
    LEFT JOIN geography4.rivers r on r.id = cr.river_id
    JOIN geography4.continents ct on ct.continent_code = c.continent_code
WHERE ct.continent_name = 'Africa'
ORDER BY c.country_name LIMIT 5;