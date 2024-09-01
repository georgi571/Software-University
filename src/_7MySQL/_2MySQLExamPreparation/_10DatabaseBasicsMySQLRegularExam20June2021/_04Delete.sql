DELETE c
FROM softuni_taxi_company.clients AS c
    LEFT JOIN softuni_taxi_company.courses AS c2 ON c.id = c2.client_id
WHERE c2.client_id IS NULL AND CHAR_LENGTH(full_name) > 3;