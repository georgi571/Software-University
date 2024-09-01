SELECT
    id,
    model,
    passengers_capacity,
    tank_capacity,
    cost
FROM airlines.airplanes
ORDER BY cost DESC, id DESC;