DELIMITER $$
CREATE FUNCTION ruk.udf_client_cards_count(name VARCHAR(30))
    RETURNS INT
    DETERMINISTIC
BEGIN
    DECLARE number_of_cards_client_has INT;

    SELECT COUNT(c2.card_number) INTO number_of_cards_client_has
    FROM ruk.clients AS c
             LEFT JOIN ruk.bank_accounts AS ba ON c.id = ba.client_id
             LEFT JOIN ruk.cards AS c2 ON ba.id = c2.bank_account_id
    WHERE c.full_name = `name`;

    RETURN number_of_cards_client_has;
END$$
DELIMITER ;