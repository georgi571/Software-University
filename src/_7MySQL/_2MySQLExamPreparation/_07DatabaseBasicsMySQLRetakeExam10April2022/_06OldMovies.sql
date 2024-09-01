SELECT
    mai.id,
    m.title,
    mai.runtime,
    mai.budget,
    mai.release_date
FROM softuni_imdbs.movies_additional_info AS mai
    JOIN softuni_imdbs.movies AS m ON mai.id = m.movie_info_id
WHERE YEAR(release_date) BETWEEN 1996 AND 1999
ORDER BY mai.runtime, mai.id
LIMIT 20;