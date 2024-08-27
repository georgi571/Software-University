DELIMITER $$
CREATE PROCEDURE bank.usp_calculate_future_value_for_account(`account_id` INT,`interest_rate` DECIMAL(19,4))
BEGIN
    SELECT
        a.id AS `account_id`,
        ah.first_name,
        ah.last_name,
        a.balance AS `current_balance`,
        bank.ufn_calculate_future_value(a.balance, interest_rate, 5) AS `balance_in_5_years`
    FROM account_holders AS ah
        JOIN accounts AS a ON ah.id = a.account_holder_id
    WHERE a.id = account_id;
END$$
DELIMITER ;