DELIMITER $$
CREATE FUNCTION instd.udf_users_photos_count(username VARCHAR(30))
    RETURNS INT
    DETERMINISTIC
BEGIN
    DECLARE number_of_photos_that_user_has_upload INT;

    SELECT
         COUNT(up.photo_id) INTO number_of_photos_that_user_has_upload
    FROM instd.users AS u
        LEFT JOIN instd.users_photos AS up ON u.id = up.user_id
    WHERE u.username = `username`
    GROUP BY u.id;

    RETURN number_of_photos_that_user_has_upload;
END$$
DELIMITER ;