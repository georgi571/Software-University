SELECT REPLACE(title, 'The', '***') AS 'title'
FROM book_library.books
WHERE SUBSTRING(title, 1, 4) = 'The ';