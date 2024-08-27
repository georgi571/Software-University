SELECT MIN(avg_salary) AS lowest_avg_salary
FROM (SELECT AVG(salary) AS avg_salary
      FROM soft_uni6.employees
      GROUP BY department_id) AS department_averages;