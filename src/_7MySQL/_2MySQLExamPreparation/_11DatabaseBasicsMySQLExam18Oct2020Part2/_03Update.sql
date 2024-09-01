UPDATE softuni_stores_system.employees AS e
    JOIN softuni_stores_system.stores AS s ON s.id = e.store_id
SET
    e.manager_id = 3,
    e.salary = salary - 500
WHERE YEAR(e.hire_date) > 2003 AND s.name != 'Cardguard' AND s.name != 'Veribet';