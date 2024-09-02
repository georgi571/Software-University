SELECT
    p.id,
    p.date AS `date_and_time`,
    p.description,
    COUNT(*) AS `commentsCount`
FROM instd.photos AS p
    JOIN instd.comments AS c ON p.id = c.photo_id
GROUP BY p.id
ORDER BY commentsCount DESC, id
LIMIT 5;