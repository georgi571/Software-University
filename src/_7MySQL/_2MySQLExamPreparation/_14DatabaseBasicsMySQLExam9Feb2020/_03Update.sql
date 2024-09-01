UPDATE fsd.coaches AS c
SET c.coach_level = c.coach_level + 1
WHERE c.first_name LIKE 'A%'
  AND EXISTS (
    SELECT 1
    FROM fsd.players_coaches AS pc
    WHERE pc.coach_id = c.id
);