SELECT
    c.name,
    COUNT(p.id) AS `total_count_of_players`,
    SUM(p.salary) AS `total_sum_of_salaries`
FROM fsd.countries AS c
    LEFT JOIN fsd.towns AS t ON c.id = t.country_id
    LEFT JOIN fsd.stadiums AS s ON t.id = s.town_id
    LEFT JOIN fsd.teams AS t2 ON s.id = t2.stadium_id
    LEFT JOIN fsd.players p on t2.id = p.team_id
GROUP BY c.name
ORDER BY total_count_of_players DESC, c.name;