SELECT
    d.first_name,
    d.last_name,
    c.make,
    c.model,
    c.mileage
FROM softuni_taxi_company.drivers AS d
    JOIN softuni_taxi_company.cars_drivers AS cd ON d.id = cd.driver_id
    JOIN softuni_taxi_company.cars AS c ON c.id = cd.car_id
WHERE mileage IS NOT NULL
ORDER BY mileage DESC, first_name;
