SELECT
    MAX(sd.speed) AS `max_speed`,
    twn.name AS `town_name`
FROM fsd.towns AS twn
    LEFT JOIN fsd.stadiums AS s on twn.id = s.town_id
    LEFT JOIN fsd.teams AS t on s.id = t.stadium_id
    LEFT JOIN fsd.players p on t.id = p.team_id
    LEFT JOIN fsd.skills_data sd on sd.id = p.skills_data_id
WHERE t.name != 'Devify'
GROUP BY twn.name
ORDER BY max_speed DESC, twn.name;