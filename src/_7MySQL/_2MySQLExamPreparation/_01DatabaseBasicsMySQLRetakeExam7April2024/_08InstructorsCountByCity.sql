SELECT
    c.name,
    COUNT(*) AS `instructors_count`
FROM go_roadie.instructors_driving_schools AS ids
    JOIN go_roadie.driving_schools AS ds ON ds.id = ids.driving_school_id
    JOIN go_roadie.cities AS c ON c.id = ds.city_id
GROUP BY c.name
HAVING instructors_count > 0
ORDER BY instructors_count DESC;