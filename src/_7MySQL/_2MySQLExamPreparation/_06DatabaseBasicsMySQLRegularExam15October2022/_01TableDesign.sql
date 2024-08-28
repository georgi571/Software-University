CREATE DATABASE restaurant2;

CREATE TABLE restaurant2.products(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(30) NOT NULL UNIQUE,
    type VARCHAR(30) NOT NULL,
    price DECIMAL(10,2) NOT NULL
);

CREATE TABLE restaurant2.clients(
    id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    birthdate DATE NOT NULL,
    card VARCHAR(50),
    review TEXT
);

CREATE TABLE restaurant2.tables(
    id INT PRIMARY KEY AUTO_INCREMENT,
    floor INT NOT NULL,
    reserved BOOL,
    capacity INT NOT NULL
);

CREATE TABLE restaurant2.waiters(
    id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    phone VARCHAR(50),
    salary DECIMAL(10,2)
);

CREATE TABLE restaurant2.orders(
    id INT PRIMARY KEY AUTO_INCREMENT,
    table_id INT NOT NULL,
    waiter_id INT NOT NULL,
    order_time TIME,
    payed_status BOOL,

    CONSTRAINT fk_orders_tables
        FOREIGN KEY (table_id)
            REFERENCES tables(id),

    CONSTRAINT fk_orders_waiters
        FOREIGN KEY (waiter_id)
            REFERENCES waiters(id)
);

CREATE TABLE restaurant2.orders_clients(
    order_id INT,
    client_id INT,

    CONSTRAINT fk_orders_clients_orders
        FOREIGN KEY (order_id)
            REFERENCES orders(id),

    CONSTRAINT fk_orders_clients_clients
        FOREIGN KEY (client_id)
            REFERENCES clients(id)
);

CREATE TABLE restaurant2.orders_products(
    order_id INT,
    product_id INT,

    CONSTRAINT fk_orders_products_orders
        FOREIGN KEY (order_id)
            REFERENCES orders(id),

    CONSTRAINT fk_orders_products_products
        FOREIGN KEY (product_id)
            REFERENCES products(id)
);
