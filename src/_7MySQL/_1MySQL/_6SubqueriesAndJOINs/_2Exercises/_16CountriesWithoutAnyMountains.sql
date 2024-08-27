SELECT
    COUNT(*) AS `country_count`
FROM geography4.countries AS c
    LEFT JOIN geography4.mountains_countries mc on c.country_code = mc.country_code
WHERE mountain_id IS NULL;
