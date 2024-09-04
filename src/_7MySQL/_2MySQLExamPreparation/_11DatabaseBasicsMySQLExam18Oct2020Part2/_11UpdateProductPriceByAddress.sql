DELIMITER $$
CREATE PROCEDURE softuni_stores_system.udp_update_product_price(address_name VARCHAR (50))
BEGIN
    DECLARE price_increment INT;

    IF LEFT(address_name, 1) = '0' THEN
        SET price_increment = 100;
    ELSE
        SET price_increment = 200;
    END IF;


    UPDATE softuni_stores_system.addresses AS a
        JOIN softuni_stores_system.stores AS s ON a.id = s.address_id
        JOIN softuni_stores_system.products_stores AS ps ON s.id = ps.store_id
        JOIN softuni_stores_system.products p on p.id = ps.product_id
    SET
        p.price = p.price + price_increment
    WHERE a.name = `address_name`;
END$$
DELIMITER ;