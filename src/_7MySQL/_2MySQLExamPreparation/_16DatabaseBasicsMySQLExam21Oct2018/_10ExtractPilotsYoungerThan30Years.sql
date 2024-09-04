SELECT
    ss.name,
    ss.manufacturer
FROM colonial_journey_management_system.spaceships AS ss
    JOIN colonial_journey_management_system.journeys AS j ON ss.id = j.spaceship_id
    JOIN colonial_journey_management_system.travel_cards AS tc ON j.id = tc.journey_id
    JOIN colonial_journey_management_system.colonists AS c ON c.id = tc.colonist_id
WHERE (DATEDIFF('2019-01-01', c.birth_date) / 365) < 30 AND job_during_journey = 'Pilot'
GROUP BY ss.name, ss.manufacturer
ORDER BY ss.name;