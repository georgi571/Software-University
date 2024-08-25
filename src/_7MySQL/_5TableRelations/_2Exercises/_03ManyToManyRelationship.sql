CREATE TABLE geography3.students (
    student_id INT PRIMARY KEY AUTO_INCREMENT,
    name           VARCHAR(255) UNIQUE
);

CREATE TABLE geography3.exams (
    exam_id        INT PRIMARY KEY AUTO_INCREMENT,
    name           VARCHAR(255)
);

CREATE TABLE geography3.students_exams (
    student_id INT,
    exam_id INT,

    CONSTRAINT pk_student_exam
        PRIMARY KEY (student_id, exam_id),

    CONSTRAINT fk_students_exams_students
        FOREIGN KEY (student_id)
            REFERENCES students (student_id),

    CONSTRAINT fk_students_exams_exams
        FOREIGN KEY (exam_id)
            REFERENCES exams (exam_id)
);

INSERT INTO geography3.students(name) VALUES
('Mila'),
('Toni'),
('Ron');

INSERT INTO geography3.exams (exam_id, name) VALUES
(101, 'Spring MVC'),
(102, 'Neo4j'),
(103, 'Oracle 11g');

INSERT INTO geography3.students_exams (student_id, exam_id) VALUES
(1, 101),
(1, 102),
(2, 101),
(3, 103),
(2, 102),
(2, 103);