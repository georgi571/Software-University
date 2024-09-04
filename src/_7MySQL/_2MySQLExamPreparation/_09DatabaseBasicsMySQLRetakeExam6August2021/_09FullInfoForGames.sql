SELECT
    g.name,
    CASE
        WHEN g.budget < 50000 THEN 'Normal budget'
        ELSE 'Insufficient budget'
    END AS `budget_level`,
    t.name,
    a.name
FROM softuni_game_dev_branch.games AS g
    LEFT JOIN softuni_game_dev_branch.games_categories AS gc ON g.id = gc.game_id
    JOIN softuni_game_dev_branch.teams AS t ON t.id = g.team_id
    JOIN softuni_game_dev_branch.offices AS o ON o.id = t.office_id
    JOIN softuni_game_dev_branch.addresses AS a ON a.id = o.address_id
WHERE g.release_date IS NULL AND gc.category_id IS NULL
ORDER BY g.name;