UPDATE soft_uni2.employees
SET salary = salary * 1.12
WHERE department_id IN(1,2,4,11);

SELECT salary FROM soft_uni2.employees;