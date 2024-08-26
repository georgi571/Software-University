DELIMITER $$
CREATE PROCEDURE bank.usp_get_holders_with_balance_higher_than(`balance` DECIMAL(19,2))
BEGIN
    SELECT
        ah.first_name, ah.last_name
    FROM account_holders AS ah
             JOIN accounts AS a ON ah.id = a.account_holder_id
    GROUP BY  ah.id, ah.first_name, ah.last_name
    HAVING SUM(a.balance) > balance
    ORDER BY ah.id;
END$$
DELIMITER ;