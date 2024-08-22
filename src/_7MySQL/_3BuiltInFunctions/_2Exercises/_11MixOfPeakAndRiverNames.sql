SELECT
    peak_name,
    river_name,
    CONCAT_WS('', LOWER(peak_name), SUBSTRING(LOWER(river_name), 2)) AS `mix`
FROM geography2.peaks, geography2.rivers
WHERE RIGHT(peak_name, 1) = LEFT(river_name, 1)
ORDER BY mix;