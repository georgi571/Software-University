SELECT
    CONCAT_WS(' ', a.first_name, a.last_name) AS `full_name`,
    a.age
FROM summer_olympics.athletes AS a
    JOIN summer_olympics.disciplines_athletes_medals AS dam ON a.id = dam.athlete_id
WHERE age = 17
GROUP BY dam.athlete_id
HAVING COUNT(*) > 0
ORDER BY dam.athlete_id
LIMIT 2;