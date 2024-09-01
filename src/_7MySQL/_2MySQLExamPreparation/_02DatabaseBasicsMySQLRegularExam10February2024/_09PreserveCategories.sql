SELECT
    p.id,
    p.name,
    CASE
        WHEN p.area <= 100 THEN 'very small'
        WHEN p.area <= 1000 THEN 'small'
        WHEN p.area <= 10000 THEN 'medium'
        WHEN p.area <= 50000 THEN 'large'
        WHEN p.area > 50000 THEN 'very large'
    END AS `category`
FROM preserves.preserves AS p
ORDER BY p.area DESC;