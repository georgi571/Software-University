DELIMITER $$
CREATE PROCEDURE softuni_game_dev_branch.udp_update_budget(min_game_rating FLOAT)
BEGIN
    UPDATE softuni_game_dev_branch.games AS g
        LEFT JOIN softuni_game_dev_branch.games_categories gc on g.id = gc.game_id
    SET
        g.release_date = DATE_ADD(g.release_date, INTERVAL 1 YEAR),
        g.budget = g.budget + 100000
    WHERE gc.category_id IS NULL AND g.rating > `min_game_rating` AND g.release_date IS NOT NULL;
END$$
DELIMITER ;
