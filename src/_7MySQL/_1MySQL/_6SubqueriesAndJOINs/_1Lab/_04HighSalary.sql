SELECT COUNT(*)
FROM soft_uni5.employees
WHERE salary > (
    SELECT avg(salary)
    FROM soft_uni5.employees
);