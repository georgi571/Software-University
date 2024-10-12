SELECT
    CONCAT_WS(' ', a.first_name, a.last_name) AS `full_name`,
    CASE
        WHEN a.age <= 18 THEN 'Teenager'
        WHEN a.age <= 25 THEN 'Young adult'
        WHEN a.age >= 26 THEN 'Adult'
    END AS `age_group`
FROM summer_olympics.athletes AS a
ORDER BY a.age DESC , a.first_name;