SELECT
    u.name,
    c.name,
    u.address,
    CASE
        WHEN tuition_fee < 800 THEN 'cheap'
        WHEN tuition_fee < 1200 THEN 'normal'
        WHEN tuition_fee < 2500 THEN 'high'
        WHEN tuition_fee >= 2500 THEN 'expensive'
    END AS `price_rank`,
    u.tuition_fee
FROM universities.universities AS u
    JOIN universities.cities c on c.id = u.city_id
ORDER BY u.tuition_fee;