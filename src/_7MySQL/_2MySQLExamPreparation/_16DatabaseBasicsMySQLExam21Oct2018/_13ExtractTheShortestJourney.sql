SELECT
    j.id,
    p.name,
    s.name,
    j.purpose
FROM colonial_journey_management_system.journeys AS j
    JOIN colonial_journey_management_system.spaceports AS s ON s.id = j.destination_spaceport_id
    JOIN colonial_journey_management_system.planets AS p ON p.id = s.planet_id
ORDER BY TIMESTAMPDIFF(SECOND, j.journey_start, j.journey_end)
LIMIT 1;