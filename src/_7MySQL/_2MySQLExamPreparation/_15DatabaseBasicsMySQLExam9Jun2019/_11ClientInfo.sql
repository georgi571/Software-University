DELIMITER $$
CREATE PROCEDURE ruk.udp_clientinfo(full_name VARCHAR(255))
BEGIN
    SELECT
        c.full_name,
        c.age,
        ba.account_number,
        CONCAT('$', ba.balance)
    FROM ruk.clients AS c
             JOIN ruk.bank_accounts AS ba ON c.id = ba.client_id
    WHERE c.full_name = `full_name`;
END$$
DELIMITER ;