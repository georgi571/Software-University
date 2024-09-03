SELECT
    c.full_name,
    COUNT(c3.id) AS `count_of_cars`,
    SUM(c2.bill) AS `total_sum`
FROM softuni_taxi_company.clients AS c
    JOIN softuni_taxi_company.courses AS c2 ON c.id = c2.client_id
    JOIN softuni_taxi_company.cars c3 on c3.id = c2.car_id
WHERE SUBSTRING(c.full_name, 2,1) = 'a'
GROUP BY c.full_name
HAVING count_of_cars > 1
ORDER BY c.full_name;