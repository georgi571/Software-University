DELIMITER $$
CREATE FUNCTION colonial_journey_management_system.udf_count_colonists_by_destination_planet(planet_name VARCHAR (30))
    RETURNS INT
    DETERMINISTIC
BEGIN
    DECLARE number_of_colonist_sent_to_this_planet INT;

    SELECT
        COUNT(tc.colonist_id) INTO number_of_colonist_sent_to_this_planet
    FROM colonial_journey_management_system.planets AS p
             LEFT JOIN colonial_journey_management_system.spaceports AS s ON p.id = s.planet_id
             LEFT JOIN colonial_journey_management_system.journeys AS j ON s.id = j.destination_spaceport_id
             LEFT JOIN colonial_journey_management_system.travel_cards AS tc ON j.id = tc.journey_id
    WHERE p.name = `planet_name`;

    RETURN number_of_colonist_sent_to_this_planet;
END$$
DELIMITER ;