SELECT
    i.first_name,
    i.last_name,
    COUNT(*) AS `students_count`,
    c.name
FROM go_roadie.instructors_students AS ins
    JOIN go_roadie.instructors AS i ON i.id = ins.instructor_id
    JOIN go_roadie.instructors_driving_schools AS ids ON i.id = ids.instructor_id
    JOIN go_roadie.driving_schools AS ds ON ds.id = ids.driving_school_id
    JOIN go_roadie.cities AS c ON c.id = ds.city_id
GROUP BY ins.instructor_id, c.name, i.first_name
HAVING students_count > 1
ORDER BY students_count DESC, i.first_name;