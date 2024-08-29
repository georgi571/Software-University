CREATE DATABASE softuni_taxi_company;

CREATE TABLE softuni_taxi_company.addresses(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE softuni_taxi_company.categories(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(10) NOT NULL
);

CREATE TABLE softuni_taxi_company.clients(
    id INT PRIMARY KEY AUTO_INCREMENT,
    full_name VARCHAR(50) NOT NULL,
    phone_number VARCHAR(20) NOT NULL
);

CREATE TABLE softuni_taxi_company.drivers(
    id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(30) NOT NULL,
    last_name VARCHAR(30) NOT NULL,
    age INT NOT NULL,
    rating FLOAT DEFAULT 5.5
);

CREATE TABLE softuni_taxi_company.cars(
    id INT PRIMARY KEY AUTO_INCREMENT,
    make VARCHAR(20) NOT NULL,
    model VARCHAR(20),
    year INT NOT NULL DEFAULT 0,
    mileage INT DEFAULT 0,
    `condition` CHAR(1) NOT NULL,
    category_id INT NOT NULL,

    CONSTRAINT fk_cars_categories
        FOREIGN KEY (category_id)
            REFERENCES categories(id)
);

CREATE TABLE softuni_taxi_company.courses(
    id INT PRIMARY KEY AUTO_INCREMENT,
    from_address_id INT  NOT NULL,
    start DATETIME NOT NULL,
    bill DECIMAL(10,2) DEFAULT 10,
    car_id INT NOT NULL,
    client_id INT NOT NULL,

    CONSTRAINT fk_courses_addresses
        FOREIGN KEY (from_address_id)
            REFERENCES addresses(id),

    CONSTRAINT fk_courses_cars
        FOREIGN KEY (car_id)
            REFERENCES cars(id),

    CONSTRAINT fk_courses_clients
        FOREIGN KEY (client_id)
            REFERENCES clients(id)
);

CREATE TABLE softuni_taxi_company.cars_drivers(
    car_id INT NOT NULL,
    driver_id INT NOT NULL,

    CONSTRAINT pk_cars_drivers
        PRIMARY KEY (car_id, driver_id),

    CONSTRAINT fk_cars_drivers_cars
        FOREIGN KEY (car_id)
            REFERENCES cars(id),

    CONSTRAINT fk_cars_drivers_drivers
        FOREIGN KEY (driver_id)
            REFERENCES drivers(id)
);