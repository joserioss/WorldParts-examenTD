SELECT
    c.category_name,
    COUNT(*)
FROM
    products p
INNER JOIN product_categories c ON
    p.category_id = c.category_id
GROUP BY
    c.category_name
ORDER BY
    COUNT(*)
DESC
    ;