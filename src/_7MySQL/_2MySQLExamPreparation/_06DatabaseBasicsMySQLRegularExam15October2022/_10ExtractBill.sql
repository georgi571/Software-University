DELIMITER $$
CREATE FUNCTION restaurant2.udf_client_bill(full_name VARCHAR(50))
    RETURNS DECIMAL(19,2)
    DETERMINISTIC
BEGIN
    DECLARE bill_for_client DECIMAL(19,2);

    SELECT
        SUM(p.price) INTO bill_for_client
    FROM restaurant2.clients AS c
             LEFT JOIN restaurant2.orders_clients AS oc ON c.id = oc.client_id
             LEFT JOIN restaurant2.orders_products AS op ON oc.order_id = op.order_id
             LEFT JOIN restaurant2.products AS p ON p.id = op.product_id
    WHERE CONCAT_WS(' ', c.first_name, c.last_name) = `full_name`
    ORDER BY c.id, oc.order_id;

    RETURN bill_for_client;
END$$
DELIMITER ;
