SELECT
    CONCAT_WS(' ', i.first_name, i.last_name) AS `full_name`,
    CASE
        WHEN YEAR(i.has_a_license_from) < 1990 THEN 'Specialist'
        WHEN YEAR(i.has_a_license_from) < 2000 THEN 'Advanced'
        WHEN YEAR(i.has_a_license_from) < 2008 THEN 'Experienced'
        WHEN YEAR(i.has_a_license_from) < 2015 THEN 'Qualified'
        WHEN YEAR(i.has_a_license_from) < 2020 THEN 'Provisional'
        WHEN YEAR(i.has_a_license_from) >= 2020 THEN 'Trainee'
    END AS `level`
FROM go_roadie.instructors AS i
ORDER BY YEAR(i.has_a_license_from), i.first_name;