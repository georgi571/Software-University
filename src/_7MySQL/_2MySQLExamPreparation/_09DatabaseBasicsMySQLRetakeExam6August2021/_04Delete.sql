DELETE g
FROM softuni_game_dev_branch.games AS g
LEFT JOIN softuni_game_dev_branch.games_categories AS gc ON g.id = gc.game_id
WHERE gc.category_id IS NULL AND g.release_date IS NULL;