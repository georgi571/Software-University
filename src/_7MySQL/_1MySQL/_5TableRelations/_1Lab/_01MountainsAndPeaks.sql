CREATE TABLE camp.mountains (
    id   INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE camp.peaks (
    id   INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    mountain_id INT,

    CONSTRAINT fk_peaks_mountains
        FOREIGN KEY (mountain_id)
            REFERENCES mountains(id)
);