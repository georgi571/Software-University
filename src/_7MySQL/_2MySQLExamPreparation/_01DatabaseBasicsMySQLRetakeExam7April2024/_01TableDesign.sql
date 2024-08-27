CREATE DATABASE go_roadie;

CREATE TABLE go_roadie.cities(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(40) NOT NULL UNIQUE
);

CREATE TABLE go_roadie.cars(
    id INT PRIMARY KEY AUTO_INCREMENT,
    brand VARCHAR(20) NOT NULL,
    model VARCHAR(20) NOT NULL UNIQUE
);

CREATE TABLE go_roadie.driving_schools(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(40) NOT NULL UNIQUE,
    night_time_driving BOOL NOT NULL,
    average_lesson_price DECIMAL(10,2),
    car_id INT NOT NULL,
    city_id INT NOT NULL,

    CONSTRAINT fk_driving_schools_cars
        FOREIGN KEY (car_id)
            REFERENCES cars(id),

    CONSTRAINT fk_driving_schools_city
        FOREIGN KEY (city_id)
            REFERENCES cities(id)
);

CREATE TABLE go_roadie.instructors(
    id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(40) NOT NULL,
    last_name VARCHAR(40) NOT NULL UNIQUE,
    has_a_license_from DATE NOT NULL
);

CREATE TABLE go_roadie.instructors_driving_schools(
    instructor_id INT,
    driving_school_id INT NOT NULL,

    CONSTRAINT fk_instructors_driving_schools_instructors
        FOREIGN KEY (instructor_id)
            REFERENCES instructors(id),

    CONSTRAINT fk_instructors_driving_schools_driving_schools
        FOREIGN KEY (driving_school_id)
            REFERENCES driving_schools(id)
);

CREATE TABLE go_roadie.students(
    id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(40) NOT NULL,
    last_name VARCHAR(40) NOT NULL UNIQUE,
    age INT,
    phone_number VARCHAR(20) UNIQUE
);

CREATE TABLE go_roadie.instructors_students(
    instructor_id INT NOT NULL,
    student_id INT NOT NULL,

    CONSTRAINT fk_instructors_students_instructors
        FOREIGN KEY (instructor_id)
            REFERENCES instructors(id),

    CONSTRAINT fk_instructors_students_students
        FOREIGN KEY (student_id)
            REFERENCES students(id)
);