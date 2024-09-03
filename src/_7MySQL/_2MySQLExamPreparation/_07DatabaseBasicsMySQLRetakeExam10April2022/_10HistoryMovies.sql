DELIMITER $$
CREATE FUNCTION softuni_imdbs.udf_actor_history_movies_count(full_name VARCHAR(50))
    RETURNS INT
    DETERMINISTIC
BEGIN
    DECLARE total_number_of_movies_actor_has_role INT;

    SELECT
        COUNT(*) INTO total_number_of_movies_actor_has_role
    FROM softuni_imdbs.actors AS a
             LEFT JOIN softuni_imdbs.movies_actors AS ma ON a.id = ma.actor_id
             LEFT JOIN softuni_imdbs.genres_movies AS gm ON ma.movie_id = gm.movie_id
    WHERE CONCAT_WS(' ', a.first_name, a.last_name) = `full_name` AND gm.genre_id = 12
    GROUP BY a.first_name, a.last_name;

    RETURN total_number_of_movies_actor_has_role;
END$$
DELIMITER ;
