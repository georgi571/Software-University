CREATE DATABASE colonial_journey_management_system;

CREATE TABLE colonial_journey_management_system.planets(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(30) NOT NULL
);

CREATE TABLE colonial_journey_management_system.spaceports(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    planet_id INT,

    CONSTRAINT fk_spaceports_planets
        FOREIGN KEY (planet_id)
            REFERENCES planets(id)
);

CREATE TABLE colonial_journey_management_system.spaceships(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    manufacturer VARCHAR(30) NOT NULL,
    light_speed_rate INT DEFAULT 0
);

CREATE TABLE colonial_journey_management_system.colonists(
    id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(20) NOT NULL,
    last_name VARCHAR(20) NOT NULL,
    ucn CHAR(10) NOT NULL UNIQUE,
    birth_date DATE NOT NULL
);

CREATE TABLE colonial_journey_management_system.journeys(
    id INT PRIMARY KEY AUTO_INCREMENT,
    journey_start DATETIME NOT NULL,
    journey_end DATETIME NOT NULL,
    purpose ENUM('Medical', 'Technical', 'Educational', 'Military'),
    destination_spaceport_id INT,
    spaceship_id INT,

    CONSTRAINT fk_journeys_spaceports
        FOREIGN KEY (destination_spaceport_id)
            REFERENCES spaceports(id),

    CONSTRAINT fk_journeys_spaceships
        FOREIGN KEY (spaceship_id)
            REFERENCES spaceships(id)
);

CREATE TABLE colonial_journey_management_system.travel_cards(
    id INT PRIMARY KEY AUTO_INCREMENT,
    card_number CHAR(10) NOT NULL UNIQUE,
    job_during_journey ENUM('Pilot','Engineer','Trooper','Cleaner','Cook'),
    colonist_id INT,
    journey_id INT,

    CONSTRAINT fk_travel_cards_colonists
        FOREIGN KEY (colonist_id)
            REFERENCES colonists(id),

    CONSTRAINT fk_travel_cards_journeys
        FOREIGN KEY (journey_id)
            REFERENCES journeys(id)
);