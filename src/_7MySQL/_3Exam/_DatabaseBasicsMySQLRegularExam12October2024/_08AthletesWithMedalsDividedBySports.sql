SELECT
    a.id,
    a.first_name,
    a.last_name,
    COUNT(dam.medal_id) AS `medals_count`,
    s.name
FROM summer_olympics.athletes AS a
    LEFT JOIN summer_olympics.disciplines_athletes_medals AS dam ON a.id = dam.athlete_id
    JOIN summer_olympics.disciplines AS d ON d.id = dam.discipline_id
    JOIN summer_olympics.sports AS s ON s.id = d.sport_id
GROUP BY a.id, a.first_name, s.name
ORDER BY medals_count DESC, a.first_name
LIMIT 10;