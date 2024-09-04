SELECT
    b.name,
    COUNT(c.card_number) AS `count_of_cards`
FROM ruk.branches AS b
    LEFT JOIN ruk.employees AS e ON b.id = e.branch_id
    LEFT JOIN ruk.employees_clients ec on e.id = ec.employee_id
    LEFT JOIN ruk.bank_accounts ba on ec.client_id = ba.client_id
    LEFT JOIN ruk.cards c on ba.id = c.bank_account_id
GROUP BY b.name
ORDER BY count_of_cards DESC, b.name;