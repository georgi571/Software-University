SELECT
    a.name,
    CASE
        WHEN HOUR(c.start) BETWEEN 6 AND 20 THEN 'Day'
        ELSE 'Night'
    END AS `day_time`,
    c.bill,
    c2.full_name,
    c3.make,
    c3.model,
    c4.name AS `category_name`
FROM softuni_taxi_company.addresses AS a
    JOIN softuni_taxi_company.courses AS c ON a.id = c.from_address_id
    JOIN softuni_taxi_company.clients c2 on c2.id = c.client_id
    JOIN softuni_taxi_company.cars c3 on c3.id = c.car_id
    JOIN softuni_taxi_company.categories c4 on c4.id = c3.category_id
ORDER BY c.id;