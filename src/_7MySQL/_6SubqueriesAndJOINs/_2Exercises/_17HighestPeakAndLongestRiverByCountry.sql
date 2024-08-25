SELECT
    c.country_name,
    MAX(p.elevation) AS `highest_peak_elevation`,
    MAX(r.length) AS `longest_river_length`
FROM geography4.countries AS c
    JOIN geography4.mountains_countries AS mc ON c.country_code = mc.country_code
    JOIN geography4.peaks AS p ON mc.mountain_id = p.mountain_id
    JOIN geography4.countries_rivers cr on c.country_code = cr.country_code
    JOIN geography4.rivers r on r.id = cr.river_id
GROUP BY c.country_name
ORDER BY highest_peak_elevation DESC, longest_river_length DESC
LIMIT 5;