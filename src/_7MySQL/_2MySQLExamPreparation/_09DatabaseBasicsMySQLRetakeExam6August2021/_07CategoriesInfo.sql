SELECT
    c.name,
    COUNT(*) AS `games_count`,
    ROUND(AVG(g.budget),2) AS`avg.budget`,
    MAX(g.rating) AS `max_rating`
FROM softuni_game_dev_branch.categories AS c
    LEFT JOIN softuni_game_dev_branch.games_categories AS gc ON c.id = gc.category_id
    LEFT JOIN softuni_game_dev_branch.games AS g ON g.id = gc.game_id
GROUP BY c.name
HAVING max_rating >= 9.5
ORDER BY games_count DESC, c.name;