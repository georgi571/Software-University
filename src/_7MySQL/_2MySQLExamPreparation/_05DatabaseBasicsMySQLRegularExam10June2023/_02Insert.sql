INSERT INTO universities.courses(name, duration_hours, start_date, teacher_name, description, university_id)
SELECT
    CONCAT_WS(' ', c.teacher_name, 'course'),
    CHAR_LENGTH(name) / 10,
    DATE_ADD(c.start_date, INTERVAL + 5 DAY),
    REVERSE(c.teacher_name),
    CONCAT('Course ', c.teacher_name, REVERSE(c.description)),
    DAY(c.start_date)
FROM universities.courses AS c
WHERE id <= 5;