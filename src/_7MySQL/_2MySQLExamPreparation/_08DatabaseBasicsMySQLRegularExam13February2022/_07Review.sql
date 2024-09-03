SELECT
    r.id,
    r.content,
    r.rating,
    r.picture_url,
    r.published_at
FROM online_store2.reviews AS r
WHERE r.content LIKE 'My%' AND CHAR_LENGTH(r.content) > 61
ORDER BY r.rating DESC;