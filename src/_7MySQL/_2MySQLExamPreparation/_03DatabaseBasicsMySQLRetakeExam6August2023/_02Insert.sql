INSERT INTO real_estate.property_transactions (property_id, buyer_id, transaction_date, bank_name, iban, is_successful)
SELECT
    po.agent_id + DAY(po.offer_datetime) AS `property_id`,
    po.agent_id + MONTH(po.offer_datetime) AS `buyer_id`,
    DATE(po.offer_datetime) AS `transaction_date`,
    CONCAT_WS(' ', 'Bank', po.agent_id) AS `bank_name`,
    CONCAT('BG',po.price, po.agent_id) AS `iban`,
    1
FROM real_estate.property_offers AS po
WHERE po.agent_id <= 2;