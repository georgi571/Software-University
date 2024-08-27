CREATE TABLE minions.minions (
    id   INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(80),
    age  INT
);

CREATE TABLE minions.towns (
    town_id   INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(80)
);