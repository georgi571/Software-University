DELIMITER $$
CREATE PROCEDURE online_store2.udp_reduce_price(category_name VARCHAR(50))
BEGIN
    UPDATE online_store2.products AS p
        JOIN online_store2.categories AS c ON c.id = p.category_id
        JOIN online_store2.reviews AS r ON r.id = p.review_id
    SET p.price = p.price * 0.70
    WHERE c.name = `category_name` AND r.rating < 4;
END$$
DELIMITER ;

