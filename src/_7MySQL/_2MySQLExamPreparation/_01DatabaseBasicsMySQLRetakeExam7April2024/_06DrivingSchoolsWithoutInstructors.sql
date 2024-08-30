SELECT
    d.id,
    d.name,
    c.brand
FROM go_roadie.instructors_driving_schools AS i
    RIGHT JOIN go_roadie.driving_schools AS d on d.id = i.driving_school_id
    JOIN go_roadie.cars AS c ON c.id = d.car_id
WHERE i.instructor_id IS NULL
ORDER BY c.brand, d.id
LIMIT 5;