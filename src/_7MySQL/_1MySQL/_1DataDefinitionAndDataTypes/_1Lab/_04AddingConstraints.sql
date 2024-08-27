ALTER TABLE gamebar.products
    ADD CONSTRAINT products___fk
        FOREIGN KEY (category_id) REFERENCES gamebar.categories (id);