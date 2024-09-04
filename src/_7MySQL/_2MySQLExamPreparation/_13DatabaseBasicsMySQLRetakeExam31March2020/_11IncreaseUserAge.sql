DELIMITER $$
CREATE PROCEDURE instd.udp_modify_user(address VARCHAR(30), town VARCHAR(30))
BEGIN

    UPDATE instd.users AS u
        JOIN instd.addresses a on u.id = a.user_id
    SET u.age = u.age + 10
    WHERE a.address = `address` AND a.town = `town`;
END$$
DELIMITER ;