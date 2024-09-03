SELECT
    m.title,
    CASE
        WHEN mai.rating <= 4 THEN 'poor'
        WHEN mai.rating <= 7 THEN 'good'
        WHEN mai.rating > 7 THEN 'excellent'
    END AS `rating`,
    CASE
        WHEN mai.has_subtitles = 1 THEN 'english'
        WHEN mai.has_subtitles = 0 THEN '-'
    END AS `subtitles`,
    mai.budget
FROM softuni_imdbs.movies AS m
    JOIN softuni_imdbs.movies_additional_info AS mai ON mai.id = m.movie_info_id
ORDER BY mai.budget DESC;