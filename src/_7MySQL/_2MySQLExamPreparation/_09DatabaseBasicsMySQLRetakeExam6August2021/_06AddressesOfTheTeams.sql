SELECT
    t.name,
    a.name,
    CHAR_LENGTH(a.name) AS `count_of_characters`
FROM softuni_game_dev_branch.teams AS t
    JOIN softuni_game_dev_branch.offices AS o ON o.id = t.office_id
    JOIN softuni_game_dev_branch.addresses AS a ON a.id = o.address_id
WHERE o.website IS NOT NULL
ORDER BY t.name;
