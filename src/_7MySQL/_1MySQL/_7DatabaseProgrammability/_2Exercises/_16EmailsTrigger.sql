CREATE TABLE bank.notification_emails(
    id        INT AUTO_INCREMENT PRIMARY KEY,
    recipient INT,
    subject   VARCHAR(255),
    body      TEXT
);

DELIMITER $$
CREATE TRIGGER bank.trg_create_notification_email
    AFTER INSERT ON bank.logs
    FOR EACH ROW
BEGIN
    DECLARE email_subject VARCHAR(255);
    DECLARE email_body TEXT;
    SET email_subject = CONCAT('Balance change for account: ', NEW.account_id);
    SET email_body = CONCAT('On ', DATE_FORMAT(NOW(), '%Y-%m-%d'), ' your balance was changed from ', NEW.old_sum, ' to ', NEW.new_sum, '.');
    INSERT INTO notification_emails (recipient, subject, body)
    VALUES (NEW.account_id, email_subject, email_body);
END$$
DELIMITER ;