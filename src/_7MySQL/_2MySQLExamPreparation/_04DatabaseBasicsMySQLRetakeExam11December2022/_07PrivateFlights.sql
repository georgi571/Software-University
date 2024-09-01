SELECT
    CONCAT(UPPER(LEFT(p.last_name, 2)), p.country_id),
    CONCAT_WS(' ', p.first_name, p.last_name),
    p.country_id
FROM airlines.passengers AS p
    LEFT JOIN airlines.flights_passengers AS fp ON p.id = fp.passenger_id
WHERE fp.flight_id IS NULL
ORDER BY p.country_id;