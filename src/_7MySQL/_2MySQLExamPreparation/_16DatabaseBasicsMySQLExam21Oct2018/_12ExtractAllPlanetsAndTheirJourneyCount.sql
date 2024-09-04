SELECT
    p.name AS `planet_name`,
    COUNT(j.id) AS `journeys_count`
FROM colonial_journey_management_system.planets AS p
    JOIN colonial_journey_management_system.spaceports AS s ON p.id = s.planet_id
    JOIN colonial_journey_management_system.journeys AS j ON s.id = j.destination_spaceport_id
GROUP BY p.name
ORDER BY journeys_count DESC, p.name;