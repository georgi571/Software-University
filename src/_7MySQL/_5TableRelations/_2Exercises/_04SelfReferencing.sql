CREATE TABLE geography3.teachers (
    teacher_id INT PRIMARY KEY AUTO_INCREMENT,
    name       VARCHAR(255),
    manager_id INT
);

INSERT INTO geography3.teachers(teacher_id, name, manager_id) VALUES
(101, 'John', null),
(102, 'Maya', 106),
(103, 'Silvia', 106),
(104, 'Ted', 105),
(105, 'Mark', 101),
(106, 'Greta', 101);

ALTER TABLE geography3.teachers
    ADD FOREIGN KEY (manager_id)
        REFERENCES teachers (teacher_id);