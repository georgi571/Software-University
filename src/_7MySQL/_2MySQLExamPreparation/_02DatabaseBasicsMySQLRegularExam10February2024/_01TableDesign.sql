CREATE DATABASE preserves;

CREATE TABLE preserves.continents(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(40) NOT NULL UNIQUE
);

CREATE TABLE preserves.countries(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(40) NOT NULL UNIQUE,
    country_code VARCHAR(10) NOT NULL UNIQUE,
    continent_id INT NOT NULL,

    CONSTRAINT fk_countries_continents
        FOREIGN KEY (continent_id)
            REFERENCES continents(id)
);

CREATE TABLE preserves.preserves(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL UNIQUE,
    latitude DECIMAL(9,6),
    longitude DECIMAL(9,6),
    area INT,
    type VARCHAR(20),
    established_on DATE
);

CREATE TABLE preserves.countries_preserves(
    country_id INT,
    preserve_id INT,

    CONSTRAINT fk_countries_preserves_countries
        FOREIGN KEY (country_id)
            REFERENCES countries(id),

    CONSTRAINT fk_countries_preserves_preserves
        FOREIGN KEY (preserve_id)
            REFERENCES preserves(id)
);

CREATE TABLE preserves.positions(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(40) NOT NULL UNIQUE,
    description TEXT,
    is_dangerous BOOL NOT NULL
);

CREATE TABLE preserves.workers(
    id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(40) NOT NULL,
    last_name VARCHAR(40) NOT NULL,
    age INT,
    personal_number VARCHAR(20) NOT NULL UNIQUE,
    salary DECIMAL(19,2),
    is_armed BOOL NOT NULL,
    start_date DATE,
    preserve_id INT NOT NULL,
    position_id INT NOT NULL,

    CONSTRAINT fk_workers_preserves
        FOREIGN KEY (preserve_id)
            REFERENCES preserves(id),

    CONSTRAINT fk_workers_positions
        FOREIGN KEY (position_id)
            REFERENCES positions(id)
);