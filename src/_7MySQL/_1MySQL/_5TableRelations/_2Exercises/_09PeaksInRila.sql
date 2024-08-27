SELECT
    mountains.mountain_range,
    peaks.peak_name,
    peaks.elevation
FROM geography3.mountains
JOIN geography3.peaks ON mountains.id = peaks.mountain_id
HAVING mountains.mountain_range = 'Rila'
ORDER BY peaks.elevation DESC ;