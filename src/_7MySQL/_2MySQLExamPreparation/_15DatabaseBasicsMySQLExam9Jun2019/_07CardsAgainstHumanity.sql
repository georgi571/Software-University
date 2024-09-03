SELECT
    c.id,
    CONCAT_WS(' : ', c.card_number, c2.full_name) AS `card_token`
FROM ruk.cards AS c
    JOIN ruk.bank_accounts AS ba ON ba.id = c.bank_account_id
    JOIN ruk.clients AS c2 ON c2.id = ba.client_id
ORDER BY c.id DESC;