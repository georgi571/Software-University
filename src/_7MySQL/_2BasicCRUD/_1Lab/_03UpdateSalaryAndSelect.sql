UPDATE hotel.employees
SET salary = salary + 100
WHERE job_title = 'Manager';

SELECT salary FROM hotel.employees;