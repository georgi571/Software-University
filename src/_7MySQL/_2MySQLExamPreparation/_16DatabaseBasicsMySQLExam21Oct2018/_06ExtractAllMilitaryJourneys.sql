SELECT
    j.id,
    j.journey_start,
    j.journey_end
FROM colonial_journey_management_system.journeys AS j
WHERE j.purpose = 'Military'
ORDER BY j.journey_start;