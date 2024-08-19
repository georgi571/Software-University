CREATE TABLE minions.people(
    id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    name VARCHAR(200) NOT NULL,
    picture BLOB,
    height DOUBLE(6,2),
    weight DOUBLE(6,2),
    gender CHAR(1) NOT NULL,
    birthdate DATE NOT NULL,
    biography BLOB
);

INSERT INTO minions.people(name, picture, height, weight, gender, birthdate, biography) VALUES
('Ivan', 'test', 1.89, 95.50, 'm', '1967-05-04', 'test'),
('Gosho', 'test', 1.79, 85.40, 'm', '1968-04-05', 'test'),
('Peter', 'test', 1.87, 92.30, 'm', '1969-03-06', 'test'),
('Maria', 'test', 1.69, 65.20, 'f', '1961-02-07', 'test'),
('Tsveti', 'test', 1.86, 55.10, 'f', '1962-01-08', 'test');
