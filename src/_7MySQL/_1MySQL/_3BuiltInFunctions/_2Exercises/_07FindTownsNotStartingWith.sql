SELECT town_id, name
FROM soft_uni3.towns
WHERE name NOT LIKE ('R%') AND name NOT LIKE ('B%') AND name NOT LIKE ('D%')
ORDER BY name;