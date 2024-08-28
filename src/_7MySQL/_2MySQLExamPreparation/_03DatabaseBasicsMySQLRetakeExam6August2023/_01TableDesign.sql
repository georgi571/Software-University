CREATE DATABASE real_estate;

CREATE TABLE real_estate.cities(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(60) NOT NULL UNIQUE
);

CREATE TABLE real_estate.property_types(
    id INT PRIMARY KEY AUTO_INCREMENT,
    type VARCHAR(40) NOT NULL UNIQUE,
    description TEXT
);

CREATE TABLE real_estate.properties(
    id INT PRIMARY KEY AUTO_INCREMENT,
    address VARCHAR(80) NOT NULL UNIQUE,
    price DECIMAL(19,2) NOT NULL,
    area DECIMAL(19,2),
    property_type_id INT,
    city_id INT,

    CONSTRAINT fk_properties_property_types
        FOREIGN KEY (property_type_id)
            REFERENCES property_types(id),

    CONSTRAINT fk_properties_cities
        FOREIGN KEY (city_id)
            REFERENCES cities(id)
);

CREATE TABLE real_estate.agents(
    id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(40) NOT NULL,
    last_name VARCHAR(40) NOT NULL,
    phone VARCHAR(20) NOT NULL UNIQUE,
    email VARCHAR(50) NOT NULL UNIQUE,
    city_id INT,

    CONSTRAINT fk_agents_cities
        FOREIGN KEY (city_id)
            REFERENCES cities(id)
);

CREATE TABLE real_estate.buyers(
    id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(40) NOT NULL,
    last_name VARCHAR(40) NOT NULL,
    phone VARCHAR(20) NOT NULL UNIQUE,
    email VARCHAR(50) NOT NULL UNIQUE,
    city_id INT,

    CONSTRAINT fk_buyers_cities
        FOREIGN KEY (city_id)
            REFERENCES cities(id)
);

CREATE TABLE real_estate.property_offers(
    property_id INT NOT NULL,
    agent_id INT NOT NULL ,
    price DECIMAL(19,2) NOT NULL,
    offer_datetime DATETIME,

    CONSTRAINT fk_properties_offers_properties
        FOREIGN KEY (property_id)
            REFERENCES properties(id),

    CONSTRAINT fk_properties_offers_agents
        FOREIGN KEY (agent_id)
            REFERENCES agents(id)
);

CREATE TABLE real_estate.property_transactions(
    id INT PRIMARY KEY AUTO_INCREMENT,
    property_id INT NOT NULL,
    buyer_id INT NOT NULL,
    transaction_date DATE,
    bank_name VARCHAR(30),
    iban VARCHAR(40) UNIQUE,
    is_successful BOOL,

    CONSTRAINT fk_property_transactions_properties
        FOREIGN KEY (property_id)
            REFERENCES properties(id),

    CONSTRAINT fk_property_transactions_buyers
        FOREIGN KEY (buyer_id)
            REFERENCES buyers(id)
);