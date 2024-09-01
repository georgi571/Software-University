DELETE w
FROM restaurant2.waiters AS w
LEFT JOIN restaurant2.orders AS o ON w.id = o.waiter_id
WHERE o.waiter_id IS NULL;