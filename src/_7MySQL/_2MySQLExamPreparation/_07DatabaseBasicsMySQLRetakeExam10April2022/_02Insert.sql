INSERT INTO softuni_imdbs.actors(first_name, last_name, birthdate, height, awards, country_id)
SELECT
    REVERSE(a.first_name),
    REVERSE(a.last_name),
    DATE_ADD(a.birthdate, INTERVAL - 2 DAY),
    a.height + 10,
    a.country_id,
    3
FROM softuni_imdbs.actors AS a
WHERE a.id <= 10;