DELIMITER $$
CREATE PROCEDURE softuni_taxi_company.udp_courses_by_address(address_name VARCHAR(100))
BEGIN
    SELECT
        a.name,
        c2.full_name,
        CASE
            WHEN c.bill <= 20 THEN 'Low'
            WHEN c.bill <= 30 THEN 'Medium'
            WHEN c.bill > 30 THEN 'High'
            END AS `level_of_bill`,
        c3.make,
        c3.`condition`,
        c4.name AS `cat_name`
    FROM softuni_taxi_company.addresses AS a
             LEFT JOIN softuni_taxi_company.courses AS c ON a.id = c.from_address_id
             LEFT JOIN softuni_taxi_company.clients AS c2 ON c2.id = c.client_id
             LEFT JOIN softuni_taxi_company.cars AS c3 ON c3.id = c.car_id
             LEFT JOIN softuni_taxi_company.categories AS c4 ON c4.id = c3.category_id
    WHERE a.name = `address_name`
    ORDER BY c3.make, c2.full_name;
END$$
DELIMITER ;
