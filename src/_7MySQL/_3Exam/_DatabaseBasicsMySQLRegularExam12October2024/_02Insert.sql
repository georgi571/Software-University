INSERT INTO summer_olympics.athletes (first_name, last_name, age, country_id)
SELECT
    UPPER(a.first_name) AS `first_name`,
    CONCAT_WS(' ', a.last_name, 'comes from', c.name) AS `last_name`,
    (a.age + c.id) AS age,
    c.id AS country_id
FROM summer_olympics.athletes AS a
    JOIN summer_olympics.countries AS c ON c.id = a.country_id
WHERE c.name LIKE ('A%');