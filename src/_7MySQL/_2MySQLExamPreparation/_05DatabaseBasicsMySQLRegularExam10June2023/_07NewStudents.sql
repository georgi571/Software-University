SELECT
    CONCAT_WS(' ', first_name, last_name) AS `full_name`,
    SUBSTRING(email, 2, 10) AS `username`,
    REVERSE(phone) AS `password`
FROM universities.students AS s
    LEFT JOIN universities.students_courses AS sc ON s.id = sc.student_id
WHERE sc.course_id IS NULL
ORDER BY password DESC;