SELECT
    CONCAT_WS(' ', u.id, u.username) AS `id_username`,
    u.email
FROM instd.users AS u
    JOIN instd.users_photos AS up ON u.id = up.user_id
WHERE u.id = up.photo_id
ORDER BY u.id;