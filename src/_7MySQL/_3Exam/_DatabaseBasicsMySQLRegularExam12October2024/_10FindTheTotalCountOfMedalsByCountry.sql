DELIMITER $$
CREATE FUNCTION summer_olympics.udf_total_medals_count_by_country (name VARCHAR(40))
    RETURNS INT
    DETERMINISTIC
BEGIN
    DECLARE total_number_of_medals INT;

    SELECT COUNT(dam.medal_id) AS `count_of_medals` INTO `total_number_of_medals`
    FROM summer_olympics.countries AS c
             JOIN summer_olympics.athletes AS a ON c.id = a.country_id
             JOIN summer_olympics.disciplines_athletes_medals AS dam ON a.id = dam.athlete_id
    WHERE c.name = `name`;

    RETURN total_number_of_medals;
END$$
DELIMITER ;