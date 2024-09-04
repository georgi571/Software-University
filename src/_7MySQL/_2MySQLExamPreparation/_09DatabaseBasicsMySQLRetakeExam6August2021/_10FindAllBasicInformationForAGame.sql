DELIMITER $$
CREATE FUNCTION softuni_game_dev_branch.udf_game_info_by_name (game_name VARCHAR (20))
    RETURNS TEXT
    DETERMINISTIC
BEGIN
    DECLARE basic_information TEXT;

    SELECT
        CONCAT('The ', g.name,' is developed by a ',t.name,' in an office with an address ', a.name) INTO basic_information
    FROM softuni_game_dev_branch.games AS g
             JOIN softuni_game_dev_branch.teams AS t ON t.id = g.team_id
             JOIN softuni_game_dev_branch.offices AS o ON o.id = t.office_id
             JOIN softuni_game_dev_branch.addresses AS a ON a.id = o.address_id
    WHERE g.name = `game_name`;

    RETURN basic_information;
END$$
DELIMITER ;