SELECT
    name
FROM soft_uni3.towns
WHERE CHAR_LENGTH(name) IN (5, 6)
ORDER BY name;