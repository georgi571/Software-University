SELECT
    CONCAT_WS(' ', a.first_name, a.last_name) AS `full_name`,
    CONCAT(REVERSE(a.last_name), CHAR_LENGTH(a.last_name), '@cast.com') AS `email`,
    '2022' - YEAR(a.birthdate) AS `age`,
    a.height
FROM softuni_imdbs.actors AS a
    LEFT JOIN softuni_imdbs.movies_actors AS ma ON a.id = ma.actor_id
WHERE ma.actor_id IS NULL
ORDER BY a.height;