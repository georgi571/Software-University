SELECT
    c.id,
    CONCAT_WS(' ', c.first_name, c.last_name) AS `full_name`
FROM colonial_journey_management_system.colonists AS c
    JOIN colonial_journey_management_system.travel_cards AS tc ON c.id = tc.colonist_id
WHERE tc.job_during_journey = 'Pilot'
ORDER BY c.id;