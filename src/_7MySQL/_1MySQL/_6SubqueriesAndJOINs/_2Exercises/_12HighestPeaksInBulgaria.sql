SELECT
    c.country_code,
    m.mountain_range,
    p.peak_name,
    p.elevation
FROM geography4.countries AS c
    JOIN geography4.mountains_countries mc on c.country_code = mc.country_code
    JOIN geography4.mountains m on m.id = mc.mountain_id
    JOIN geography4.peaks p on m.id = p.mountain_id
WHERE c.country_name = 'Bulgaria' AND p.elevation > 2835
ORDER BY p.elevation DESC;