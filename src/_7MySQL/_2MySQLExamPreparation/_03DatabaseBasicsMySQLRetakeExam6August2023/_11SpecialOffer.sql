DELIMITER $$
CREATE PROCEDURE real_estate.udp_special_offer(first_name VARCHAR(50))
BEGIN
    UPDATE real_estate.property_offers AS po
        JOIN real_estate.agents AS a ON a.id = po.agent_id
    SET po.price = po.price * 0.90
    WHERE a.first_name = `first_name`;
END$$
DELIMITER ;