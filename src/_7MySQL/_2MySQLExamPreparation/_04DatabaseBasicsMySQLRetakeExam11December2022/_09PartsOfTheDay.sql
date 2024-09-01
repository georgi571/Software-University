SELECT
    flight_code,
    departure,
    CASE
        WHEN HOUR(departure) BETWEEN '05:00' AND '11:59' THEN 'Morning'
        WHEN HOUR(departure) BETWEEN '12:00' AND '16:59' THEN 'Afternoon'
        WHEN HOUR(departure) BETWEEN '17:00' AND '20:59' THEN 'Evening'
        WHEN HOUR(departure) BETWEEN '21:00' AND '23:59' THEN 'Night'
        WHEN HOUR(departure) BETWEEN '00:00' AND '04:59' THEN 'Night'
        END AS `day_part`
FROM airlines.flights
ORDER BY flight_code DESC;