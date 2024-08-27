SELECT country_name, country_code, if(currency_code = 'EUR', 'Euro', 'Not Euro' ) AS currency
FROM geography.countries
ORDER BY country_name;