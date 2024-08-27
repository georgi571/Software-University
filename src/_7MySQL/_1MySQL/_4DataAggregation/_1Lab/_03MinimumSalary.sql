SELECT department_id, ROUND(MIN(salary), 2) AS `Average Salary`
FROM restaurant.employees
GROUP BY department_id
HAVING `Average Salary` > 800;