INSERT INTO preserves.preserves (name, latitude, longitude, area, type, established_on)
SELECT
    CONCAT(name, '', 'is in South Hemisphere') AS `name`,
    latitude,
    longitude,
    area * id,
    LOWER(type),
    established_on
FROM preserves.preserves
WHERE latitude < 0;