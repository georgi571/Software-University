CREATE TABLE bank.logs (
    log_id      INT AUTO_INCREMENT PRIMARY KEY,
    account_id  INT,
    old_sum     DECIMAL(19, 4),
    new_sum     DECIMAL(19, 4)
);

DELIMITER $$
CREATE TRIGGER bank.trg_log_balance_change
    AFTER UPDATE ON bank.accounts
    FOR EACH ROW
BEGIN
    IF OLD.balance <> NEW.balance THEN
        INSERT INTO logs (account_id, old_sum, new_sum)
        VALUES (NEW.id, OLD.balance, NEW.balance);
    END IF;
END$$
DELIMITER ;