DELIMITER $$
CREATE PROCEDURE universities.udp_graduate_all_students_by_year(year_started INT)
BEGIN
    UPDATE universities.students AS s
        JOIN universities.students_courses AS sc ON s.id = sc.student_id
        JOIN universities.courses AS c ON c.id = sc.course_id
    SET
        s.is_graduated = 1
    WHERE YEAR(c.start_date) = `year_started`;
END$$
DELIMITER ;