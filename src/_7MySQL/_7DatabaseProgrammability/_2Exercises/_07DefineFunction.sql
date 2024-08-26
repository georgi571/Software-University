DELIMITER $$
CREATE FUNCTION soft_uni8.ufn_is_word_comprised(`set_of_letters` varchar(50), `word` varchar(50))
    RETURNS TINYINT
    DETERMINISTIC
BEGIN
    RETURN (
        SELECT word REGEXP CONCAT('^[', set_of_letters, ']+$')
    );
END$$
DELIMITER ;