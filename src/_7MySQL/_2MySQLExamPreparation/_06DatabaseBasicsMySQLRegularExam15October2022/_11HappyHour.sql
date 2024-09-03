DELIMITER $$
CREATE PROCEDURE restaurant2.udp_happy_hour(type VARCHAR(50))
BEGIN
    UPDATE restaurant2.products AS p
    SET
        p.price = p.price * 0.80
    WHERE p.type = `type` AND p.price >= 10;
END$$
DELIMITER ;