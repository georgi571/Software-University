DELIMITER $$
CREATE FUNCTION softuni_taxi_company.udf_courses_by_client (phone_num VARCHAR (20))
    RETURNS INT
    DETERMINISTIC
BEGIN
    DECLARE number_of_courses_from_this_phone_number INT;

    SELECT
        COUNT(c2.id) INTO number_of_courses_from_this_phone_number
    FROM softuni_taxi_company.clients AS c
             LEFT JOIN softuni_taxi_company.courses AS c2 ON c.id = c2.client_id
    WHERE c.phone_number = `phone_num`
    GROUP BY c.phone_number;

    RETURN number_of_courses_from_this_phone_number;
END$$
DELIMITER ;