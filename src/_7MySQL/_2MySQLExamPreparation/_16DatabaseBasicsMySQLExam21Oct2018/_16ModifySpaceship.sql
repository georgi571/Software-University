DELIMITER $$
CREATE PROCEDURE colonial_journey_management_system.udp_modify_spaceship_light_speed_rate(spaceship_name VARCHAR(50), light_speed_rate_increse INT)
BEGIN
    DECLARE spaceship_exists INT DEFAULT 0;

    START TRANSACTION;

    SELECT COUNT(*) INTO spaceship_exists
    FROM colonial_journey_management_system.spaceships
    WHERE name = spaceship_name;

    IF spaceship_exists > 0 THEN
        UPDATE colonial_journey_management_system.spaceships
        SET light_speed_rate = light_speed_rate + `light_speed_rate_increse`
        WHERE name = `spaceship_name`;

        COMMIT;
    ELSE
        ROLLBACK;
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'Spaceship you are trying to modify does not exist.';
    END IF;
END$$
DELIMITER ;