DELETE c
FROM colonial_journey_management_system.colonists AS c
    LEFT JOIN colonial_journey_management_system.travel_cards AS tc ON c.id = tc.colonist_id
    LEFT JOIN colonial_journey_management_system.journeys AS j ON j.id = tc.journey_id
WHERE tc.journey_id is NULL;