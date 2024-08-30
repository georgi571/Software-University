SELECT
    CONCAT_WS(' ', first_name, last_name) AS `full_name`,
    age
FROM go_roadie.students
WHERE age = 19 AND first_name LIKE ('%a%')
ORDER BY id;