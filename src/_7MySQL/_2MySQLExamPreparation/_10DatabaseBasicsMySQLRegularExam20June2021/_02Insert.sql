INSERT INTO softuni_taxi_company.clients(full_name, phone_number)
SELECT
    CONCAT_WS(' ', d.first_name, d.last_name),
    CONCAT('(088) 9999', d.id * 2)
FROM softuni_taxi_company.drivers AS d
WHERE d.id BETWEEN 10 AND 20;