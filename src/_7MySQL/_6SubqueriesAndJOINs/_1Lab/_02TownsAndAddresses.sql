SELECT
    t.town_id,
    t.name,
    a.address_text
FROM soft_uni5.towns AS t
JOIN soft_uni5.addresses AS a on t.town_id = a.town_id
WHERE t.name IN ('San Francisco', 'Sofia', 'Carnation')
ORDER BY t.town_id, a.address_id;