INSERT INTO instd.addresses(address, town, country, user_id)
SELECT
    u.username,
    u.password,
    u.ip,
    u.age
FROM instd.users AS u
WHERE u.gender = 'M';