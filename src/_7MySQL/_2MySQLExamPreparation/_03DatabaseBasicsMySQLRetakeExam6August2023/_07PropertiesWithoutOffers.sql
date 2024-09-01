SELECT
    LEFT(p.address, 6) AS `agent_name`,
    LENGTH(p.address) * 5430 AS `price`
FROM real_estate.properties AS p
    LEFT JOIN real_estate.property_offers AS po ON p.id = po.property_id
WHERE po.property_id IS NULL
ORDER BY agent_name DESC, price DESC;