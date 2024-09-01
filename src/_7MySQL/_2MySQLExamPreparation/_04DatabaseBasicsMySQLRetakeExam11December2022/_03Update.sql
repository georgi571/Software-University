UPDATE airlines.flights AS f
    JOIN airlines.countries AS c ON c.id = f.departure_country
SET f.airplane_id = f.airplane_id + 1
WHERE c.name = 'Armenia';
