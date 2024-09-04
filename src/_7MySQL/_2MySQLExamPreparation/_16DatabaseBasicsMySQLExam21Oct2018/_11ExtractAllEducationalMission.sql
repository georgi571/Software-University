SELECT
    p.name,
    s.name
FROM colonial_journey_management_system.planets AS p
    JOIN colonial_journey_management_system.spaceports AS s ON p.id = s.planet_id
    JOIN colonial_journey_management_system.journeys AS j ON s.id = j.destination_spaceport_id
WHERE j.purpose = 'Educational'
ORDER BY s.name DESC;