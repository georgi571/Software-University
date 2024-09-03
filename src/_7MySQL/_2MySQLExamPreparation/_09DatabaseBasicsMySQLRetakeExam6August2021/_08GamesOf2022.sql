SELECT
    g.name,
    g.release_date,
    CONCAT(LEFT(g.description, 10), '...') AS `summary`,
    CASE
        WHEN MONTH(release_date) IN (1,2,3) THEN 'Q1'
        WHEN MONTH(release_date) IN (4,5,6) THEN 'Q2'
        WHEN MONTH(release_date) IN (7,8,9) THEN 'Q3'
        WHEN MONTH(release_date) IN (10,11,12) THEN 'Q4'
    END AS `quarter`,
    t.name
FROM softuni_game_dev_branch.games AS g
    JOIN softuni_game_dev_branch.teams AS t ON t.id = g.team_id
WHERE
    YEAR(release_date) = 2022 AND
    MONTH(release_date) IN (2,4,6,8,10,12) AND
    g.name LIKE ('%2')
ORDER BY quarter;