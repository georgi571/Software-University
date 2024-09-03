SELECT
    p.id AS `photo_id`,
    (SELECT COUNT(l.id) FROM instd.likes l WHERE l.photo_id = p.id) AS `likes_count`,
    (SELECT COUNT(c.id) FROM instd.comments c WHERE c.photo_id = p.id) AS `comments_count`
FROM instd.photos AS p
    LEFT JOIN instd.users_photos AS up ON p.id = up.photo_id
    LEFT JOIN instd.likes AS l ON up.photo_id = l.photo_id
    LEFT JOIN instd.comments AS c ON up.photo_id = c.photo_id
GROUP BY p.id
ORDER BY likes_count DESC, comments_count DESC, p.id;