DELIMITER $$
CREATE FUNCTION preserves.udf_average_salary_by_position_name (name VARCHAR(40))
    RETURNS DECIMAL(19, 2)
    DETERMINISTIC
BEGIN
    DECLARE average_salary_by_position DECIMAL(19, 2);

    SELECT AVG(w.salary) INTO average_salary_by_position
    FROM preserves.positions AS p
        JOIN preserves.workers w on p.id = w.position_id
    WHERE p.name = `name`;

    RETURN average_salary_by_position;
END$$
DELIMITER ;
