SELECT
    id,
    first_name,
    last_name,
    birthdate,
    card,
    review
FROM restaurant2.clients
ORDER BY birthdate DESC, id DESC;