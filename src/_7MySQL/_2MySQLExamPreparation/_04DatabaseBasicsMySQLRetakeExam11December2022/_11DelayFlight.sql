DELIMITER $$
CREATE PROCEDURE airlines.udp_delay_flight(code VARCHAR(50))
BEGIN
    UPDATE airlines.flights AS f
    SET
        f.has_delay = 1,
        f.departure = DATE_ADD(f.departure, INTERVAL 30 MINUTE)
    WHERE f.flight_code = `code`;
END$$
DELIMITER ;