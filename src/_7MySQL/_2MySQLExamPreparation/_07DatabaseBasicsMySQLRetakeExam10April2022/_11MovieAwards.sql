DELIMITER $$
CREATE PROCEDURE softuni_imdbs.udp_award_movie(movie_title VARCHAR(50))
BEGIN
    UPDATE softuni_imdbs.actors AS a
        JOIN softuni_imdbs.movies_actors AS ma ON a.id = ma.actor_id
        JOIN softuni_imdbs.movies AS m ON m.id = ma.movie_id
    SET
        a.awards = a.awards + 1
    WHERE m.title = `movie_title`;
END$$
DELIMITER ;