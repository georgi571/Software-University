CREATE TABLE minions.users (
    id              INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    username        VARCHAR(30) UNIQUE              NOT NULL,
    password        VARCHAR(26)                     NOT NULL,
    profile_picture BLOB,
    last_login_time DATETIME,
    is_deleted      BOOL
);

INSERT INTO minions.users(username, password, profile_picture, last_login_time, is_deleted) VALUES
('Ivan1', '123', 'test', NOW(), false),
('Gosho2', '234', 'test', NOW(), false),
('Peter3', '345', 'test', NOW(), false),
('Maria4', '456', 'test', NOW(), false),
('Tsveti5', '567', 'test', NOW(), false);