ALTER TABLE minions.minions
    ADD COLUMN town_id INT;

ALTER TABLE minions.minions
    ADD CONSTRAINT minions_fk
        FOREIGN KEY (town_id) REFERENCES minions.towns (id);