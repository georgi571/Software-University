SELECT
    id,
    first_name,
    last_name,
    phone,
    email,
    city_id
FROM real_estate.agents
ORDER BY city_id DESC, phone DESC;