SELECT
    COUNT(*) AS `count`
FROM colonial_journey_management_system.colonists AS c
    JOIN colonial_journey_management_system.travel_cards AS tc ON c.id = tc.colonist_id
    JOIN colonial_journey_management_system.journeys AS j ON j.id = tc.journey_id
WHERE j.purpose = 'Technical';