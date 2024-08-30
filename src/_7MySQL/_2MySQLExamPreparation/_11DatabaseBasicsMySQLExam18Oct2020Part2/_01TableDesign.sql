CREATE DATABASE softuni_stores_system;

CREATE TABLE softuni_stores_system.pictures(
    id INT PRIMARY KEY AUTO_INCREMENT,
    url VARCHAR(100) NOT NULL,
    added_on DATETIME NOT NULL
);

CREATE TABLE softuni_stores_system.categories(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(40) NOT NULL UNIQUE
);

CREATE TABLE softuni_stores_system.products(
    id INT PRIMARY KEY AUTO_INCREMENT AUTO_INCREMENT,
    name VARCHAR(40) NOT NULL UNIQUE,
    best_before DATE,
    price DECIMAL(10,2) NOT NULL,
    description TEXT,
    category_id INT NOT NULL,
    picture_id INT NOT NULL,

    CONSTRAINT fk_products_categories
        FOREIGN KEY (category_id)
            REFERENCES categories(id),

    CONSTRAINT fk_products_pictures
        FOREIGN KEY (picture_id)
            REFERENCES pictures(id)
);

CREATE TABLE softuni_stores_system.towns(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(20) NOT NULL UNIQUE
);

CREATE TABLE softuni_stores_system.addresses(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL UNIQUE,
    town_id INT,

    CONSTRAINT fk_addresses_towns
        FOREIGN KEY (town_id)
            REFERENCES towns(id)
);

CREATE TABLE softuni_stores_system.stores(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(20) NOT NULL UNIQUE,
    rating FLOAT NOT NULL,
    has_parking BOOL DEFAULT FALSE,
    address_id INT NOT NULL,

    CONSTRAINT fk_stores_addresses
        FOREIGN KEY (address_id)
            REFERENCES addresses(id)
);

CREATE TABLE softuni_stores_system.products_stores(
    product_id INT NOT NULL,
    store_id INT NOT NULL,

    CONSTRAINT pk_products_stores
        PRIMARY KEY (product_id, store_id),

    CONSTRAINT fk_products_stores_products
        FOREIGN KEY (product_id)
            REFERENCES products(id),

    CONSTRAINT fk_products_stores_stores
        FOREIGN KEY (store_id)
            REFERENCES stores(id)
);

CREATE TABLE softuni_stores_system.employees(
    id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(15) NOT NULL,
    middle_name CHAR(1),
    last_name VARCHAR(20) NOT NULL,
    salary DECIMAL(19,2) DEFAULT 0,
    hire_date DATE NOT NULL,
    manager_id INT,
    store_id INT NOT NULL,

    CONSTRAINT fk_employees_employees_manager
        FOREIGN KEY (manager_id)
            REFERENCES employees(id),

    CONSTRAINT fk_employees_stores
        FOREIGN KEY (store_id)
            REFERENCES stores(id)
);