SELECT
    c.name,
    c.currency,
    COUNT(*) AS `booked_tickets`
FROM airlines.flights_passengers AS fp
    JOIN airlines.flights AS f on f.id = fp.flight_id
    JOIN airlines.passengers p on p.id = fp.passenger_id
    JOIN airlines.countries c on c.id = f.destination_country
GROUP BY f.destination_country
HAVING booked_tickets >= 20
ORDER BY booked_tickets DESC;