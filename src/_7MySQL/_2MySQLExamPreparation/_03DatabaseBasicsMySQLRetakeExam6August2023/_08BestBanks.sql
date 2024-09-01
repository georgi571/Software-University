SELECT
    bank_name,
    COUNT(*) AS `count`
FROM real_estate.property_transactions
GROUP BY bank_name
HAVING count >= 9
ORDER BY count DESC, bank_name;