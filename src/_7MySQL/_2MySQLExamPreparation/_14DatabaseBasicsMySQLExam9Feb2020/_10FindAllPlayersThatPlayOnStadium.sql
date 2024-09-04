DELIMITER $$
CREATE FUNCTION fsd.udf_stadium_players_count (stadium_name VARCHAR(30))
    RETURNS INT
    DETERMINISTIC
BEGIN
    DECLARE number_of_photos_that_user_has_upload INT;

    SELECT COUNT(p.id) INTO number_of_photos_that_user_has_upload
    FROM fsd.stadiums AS s
             LEFT JOIN fsd.teams t on s.id = t.stadium_id
             LEFT JOIN fsd.players p on t.id = p.team_id
    WHERE s.name = `stadium_name`;

    RETURN number_of_photos_that_user_has_upload;
END$$
DELIMITER ;