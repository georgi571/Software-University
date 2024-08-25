SELECT
    vehicles.driver_id,
    vehicles.vehicle_type,
    CONCAT_WS(' ', campers.first_name, campers.last_name) AS `driver_name`
FROM camp.vehicles
JOIN camp.campers ON vehicles.driver_id = campers.id;