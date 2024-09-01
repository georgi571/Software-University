SELECT
    w.id,
    w.first_name,
    w.last_name,
    p.name,
    c.country_code
FROM preserves.workers AS w
    JOIN preserves.preserves AS p ON p.id = w.preserve_id
    JOIN preserves.countries_preserves AS cp ON p.id = cp.preserve_id
    JOIN preserves.countries c on c.id = cp.country_id
WHERE salary > 5000 AND age < 50
ORDER BY c.country_code;