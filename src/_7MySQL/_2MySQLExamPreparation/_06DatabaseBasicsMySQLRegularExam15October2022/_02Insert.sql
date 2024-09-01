INSERT INTO restaurant2.products(name, type, price)
SELECT
    CONCAT_WS(' ', w.last_name, 'specialty'),
    'Cocktail',
    CEIL(w.salary * 0.01)
FROM restaurant2.waiters AS w
WHERE w.id > 6;