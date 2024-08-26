DELIMITER $$
CREATE PROCEDURE bank.usp_get_holders_full_name()
BEGIN
    SELECT
        concat_ws(' ', first_name, last_name) AS `full_name`
    FROM bank.account_holders
    ORDER BY full_name, id;
END$$
DELIMITER ;