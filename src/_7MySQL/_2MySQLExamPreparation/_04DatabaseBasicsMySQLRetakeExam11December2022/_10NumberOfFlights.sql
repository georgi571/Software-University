DELIMITER $$
CREATE FUNCTION airlines.udf_count_flights_from_country(country VARCHAR(50))
    RETURNS INT
    DETERMINISTIC
BEGIN
    DECLARE total_flight_from_country INT;

    SELECT
        COUNT(*) INTO total_flight_from_country
    FROM airlines.flights AS f
             JOIN airlines.countries AS c ON c.id = f.departure_country
    WHERE c.name = `country`;

    RETURN total_flight_from_country;
END$$
DELIMITER ;