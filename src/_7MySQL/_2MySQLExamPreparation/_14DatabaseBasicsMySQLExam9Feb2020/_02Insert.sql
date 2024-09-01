INSERT INTO fsd.coaches(first_name, last_name, salary, coach_level)
SELECT
    p.first_name,
    p.last_name,
    p.salary * 2,
    CHAR_LENGTH(p.first_name)
FROM fsd.players AS p
WHERE p.age >= 45;