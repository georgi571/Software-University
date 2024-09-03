SELECT
    c.id,
    c.make,
    c.mileage,
    COUNT(c2.start) AS `count_of_courses`,
    ROUND(AVG(c2.bill),2) AS `avg_bill`
FROM softuni_taxi_company.cars AS c
    LEFT JOIN softuni_taxi_company.courses c2 on c.id = c2.car_id
GROUP BY c.id
HAVING count_of_courses != 2
ORDER BY count_of_courses DESC, c.id;