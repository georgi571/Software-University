CREATE DATABASE online_store;

CREATE TABLE online_store.cities(
    city_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50)
);

CREATE TABLE online_store.customers(
    customer_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50),
    birthday DATE,
    city_id INT,

    CONSTRAINT fk_customers_cities
        FOREIGN KEY (city_id)
            REFERENCES cities(city_id)
);

CREATE TABLE online_store.orders (
    order_id INT PRIMARY KEY AUTO_INCREMENT,
    customer_id INT,

    CONSTRAINT fk_orders_customers
        FOREIGN KEY (customer_id)
            REFERENCES customers(customer_id)
);

CREATE TABLE online_store.item_types (
    item_type_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50)
);

CREATE TABLE online_store.items (
    item_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50),
    item_type_id INT,

    CONSTRAINT fk_items_item_types
        FOREIGN KEY (item_type_id)
            REFERENCES item_types(item_type_id)
);

CREATE TABLE online_store.order_items(
    order_id INT,
    item_id INT,

    CONSTRAINT pk_order_item
        PRIMARY KEY (order_id, item_id),

    CONSTRAINT fk_order_item_orders
        FOREIGN KEY (order_id)
            REFERENCES orders(order_id),

    CONSTRAINT fk_order_item_items
        FOREIGN KEY (item_id)
            REFERENCES items(item_id)
);