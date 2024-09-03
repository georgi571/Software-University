SELECT
    t.name,
    t.established,
    t.fan_base,
    COUNT(p.id) AS `players_count`
FROM fsd.teams AS t
    LEFT JOIN fsd.players AS p ON t.id = p.team_id
GROUP BY t.id, t.fan_base
ORDER BY players_count DESC, t.fan_base DESC;