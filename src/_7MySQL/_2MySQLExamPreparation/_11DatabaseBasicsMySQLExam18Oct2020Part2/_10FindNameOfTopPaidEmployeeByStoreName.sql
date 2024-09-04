DELIMITER $$
CREATE FUNCTION softuni_stores_system.udf_top_paid_employee_by_store(store_name VARCHAR(50))
    RETURNS TEXT
    DETERMINISTIC
BEGIN
    DECLARE full_name_of_top_paid_employee TEXT;

    SELECT
        CONCAT(e.first_name, ' ', LEFT(e.middle_name,1), '. ', e.last_name, ' works in store for ', FLOOR(DATEDIFF('2020-10-18', e.hire_date) / 365), ' years') INTO full_name_of_top_paid_employee
    FROM softuni_stores_system.employees AS e
             JOIN softuni_stores_system.stores AS s ON s.id = e.store_id
    WHERE s.name = `store_name`
    ORDER BY e.salary DESC
    LIMIT 1;

    RETURN full_name_of_top_paid_employee;
END$$
DELIMITER ;