SELECT
    COUNT(*) AS `students_count`,
    u.name
FROM universities.universities AS u
    JOIN universities.courses AS c ON u.id = c.university_id
    JOIN universities.students_courses sc on c.id = sc.course_id
GROUP BY u.name
HAVING students_count >= 8
ORDER BY students_count DESC, u.name DESC;