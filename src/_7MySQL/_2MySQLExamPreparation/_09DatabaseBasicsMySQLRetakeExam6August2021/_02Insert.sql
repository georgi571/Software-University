INSERT INTO softuni_game_dev_branch.games(name, rating, budget, team_id)
SELECT
    REVERSE(LOWER(SUBSTRING(t.name, 2))),
    t.id,
    t.leader_id * 1000,
    t.id
FROM softuni_game_dev_branch.teams AS t
WHERE t.id <= 9;