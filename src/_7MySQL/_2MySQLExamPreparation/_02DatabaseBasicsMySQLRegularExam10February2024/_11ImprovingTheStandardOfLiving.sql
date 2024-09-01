DELIMITER $$
CREATE PROCEDURE preserves.udp_increase_salaries_by_country(country_name VARCHAR(40))
BEGIN
    UPDATE preserves.workers AS w
        JOIN preserves.countries_preserves AS cp ON w.preserve_id = cp.preserve_id
        JOIN preserves.countries AS c ON c.id = cp.country_id
    SET w.salary = w.salary * 1.05
    WHERE c.name = `country_name`;
END$$
DELIMITER ;