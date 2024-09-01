DELETE f
FROM airlines.flights AS f
LEFT JOIN airlines.flights_passengers AS fp ON f.id = fp.flight_id
WHERE fp.passenger_id IS NULL;