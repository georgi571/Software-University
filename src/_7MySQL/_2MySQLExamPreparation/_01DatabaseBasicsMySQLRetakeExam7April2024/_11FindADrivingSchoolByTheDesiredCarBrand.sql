DELIMITER $$
CREATE PROCEDURE go_roadie.udp_find_school_by_car(brand VARCHAR(20))
BEGIN
    SELECT
        ds.name,
        ds.average_lesson_price
    FROM go_roadie.driving_schools AS ds
             JOIN go_roadie.cars AS c ON c.id = ds.car_id
    WHERE c.brand = `brand`
    ORDER BY ds.average_lesson_price DESC;
END$$
DELIMITER ;


