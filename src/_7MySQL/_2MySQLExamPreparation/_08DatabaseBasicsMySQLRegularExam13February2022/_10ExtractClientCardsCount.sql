DELIMITER $$
CREATE FUNCTION online_store2.udf_customer_products_count(name VARCHAR(30))
    RETURNS INT
    DETERMINISTIC
BEGIN
    DECLARE total_number_of_product_a_customer_order INT;

    SELECT
        COUNT(*) INTO total_number_of_product_a_customer_order
    FROM online_store2.orders AS o
             LEFT JOIN online_store2.customers AS c ON c.id = o.customer_id
             LEFT JOIN online_store2.orders_products AS op ON o.id = op.order_id
    WHERE c.first_name = `name`;

    RETURN total_number_of_product_a_customer_order;
END$$
DELIMITER ;