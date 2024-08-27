SELECT
    c.continent_code,
    c.currency_code,
    COUNT(*) AS `currency_usage`
FROM geography4.countries AS c
GROUP BY c.continent_code, c.currency_code
HAVING currency_usage > 1 AND currency_usage = (
        SELECT
        COUNT(*) AS `max_usage`
        FROM geography4.countries
        WHERE continent_code = c.continent_code
        GROUP BY currency_code
        ORDER BY max_usage DESC LIMIT 1
    )
ORDER BY c.continent_code, c.currency_code;