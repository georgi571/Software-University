INSERT INTO colonial_journey_management_system.travel_cards(card_number, job_during_journey, colonist_id, journey_id)
SELECT
    CASE
        WHEN c.birth_date > '1980-01-01' THEN CONCAT(YEAR(c.birth_date),DAY(c.birth_date), LEFT(c.ucn, 4))
        ELSE CONCAT(YEAR(c.birth_date),MONTH(c.birth_date), RIGHT(c.ucn, 4))
    END AS `card_number`,
    CASE
        WHEN c.id % 2 = 0 THEN 'Pilot'
        WHEN c.id % 3 = 0 THEN 'Cook'
        ELSE 'Engineer'
    END AS `job_during_journey`,
    c.id,
    LEFT(c.ucn, 1)
FROM colonial_journey_management_system.colonists AS c
WHERE c.id BETWEEN 96 AND 100;