SELECT country_name, iso_code
FROM geography2.countries
WHERE country_name LIKE ('%A%A%A%')
ORDER BY iso_code;