INSERT INTO online_store2.reviews(content, picture_url, published_at, rating)
SELECT
    LEFT(p.description, 15),
    REVERSE(p.name),
    '2010-10-10',
    p.price / 8
FROM online_store2.products AS p
WHERE p.id >= 5;