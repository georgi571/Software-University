DELIMITER $$
CREATE FUNCTION universities.udf_average_alumni_grade_by_course_name(course_name VARCHAR(60))
    RETURNS DECIMAL(19,2)
    DETERMINISTIC
BEGIN
    DECLARE average_grade_by_course DECIMAL(19,2);

    SELECT
        AVG(sc.grade) INTO average_grade_by_course
    FROM universities.courses AS c
             JOIN universities.students_courses AS sc ON c.id = sc.course_id
             JOIN universities.students AS s ON s.id = sc.student_id
    WHERE c.name = `course_name` AND s.is_graduated = 1;

    RETURN average_grade_by_course;
END$$
DELIMITER ;