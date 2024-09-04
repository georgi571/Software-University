SELECT
    s.name,
    s2.name
FROM colonial_journey_management_system.spaceships AS s
    JOIN colonial_journey_management_system.journeys j on s.id = j.spaceship_id
    JOIN colonial_journey_management_system.spaceports s2 on s2.id = j.destination_spaceport_id
WHERE s.light_speed_rate = (
    SELECT
        MAX(s.light_speed_rate)
    FROM colonial_journey_management_system.spaceships AS s
          );