UPDATE softuni_game_dev_branch.employees AS e
    JOIN softuni_game_dev_branch.teams AS t ON e.id = t.leader_id
SET e.salary = e.salary + 1000
WHERE e.age < 40 AND e.salary < 5000 AND e.id = t.leader_id;