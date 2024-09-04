DELIMITER $$
CREATE PROCEDURE fsd.udp_find_playmaker(min_dribble_points INT, team_name VARCHAR(45))
BEGIN
    DECLARE avg_speed FLOAT;

    SELECT AVG(speed)
    INTO avg_speed
    FROM fsd.skills_data;

    SELECT
        CONCAT_WS(' ', p.first_name, p.last_name) AS `full_name`,
        p.age,
        p.salary,
        sd.dribbling,
        sd.speed,
        t.name
    FROM fsd.players AS p
             JOIN fsd.skills_data AS sd ON sd.id = p.skills_data_id
             JOIN fsd.teams t on t.id = p.team_id
    WHERE sd.dribbling >= min_dribble_points AND t.name = `team_name`
    ORDER BY speed DESC
    LIMIT 1;
END$$
DELIMITER ;
