DELIMITER $$
CREATE FUNCTION real_estate.udf_offers_from_city_name (cityName VARCHAR(50))
    RETURNS INT
    DETERMINISTIC
BEGIN
    DECLARE total_numbers_of_offer_from_that_city INT;

    SELECT COUNT(*) INTO total_numbers_of_offer_from_that_city
    FROM real_estate.property_offers AS p
        JOIN real_estate.properties p2 on p2.id = p.property_id
        JOIN real_estate.cities c on c.id = p2.city_id
    WHERE c.name = `cityName`
    GROUP BY c.name;

    RETURN total_numbers_of_offer_from_that_city;
END$$
DELIMITER ;