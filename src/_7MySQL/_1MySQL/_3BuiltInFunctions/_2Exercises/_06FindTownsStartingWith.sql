SELECT town_id, name
FROM soft_uni3.towns
WHERE name LIKE ('M%') OR name LIKE ('K%') OR name LIKE ('B%') OR name LIKE ('E%')
ORDER BY name;