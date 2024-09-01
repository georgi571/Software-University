UPDATE instd.addresses
SET country = CASE
    WHEN LEFT(country, 1) = 'B' THEN 'Blocked'
    WHEN LEFT(country, 1) = 'T' THEN 'Test'
    WHEN LEFT(country, 1) = 'P' THEN 'In Progress'
    ELSE country
END;