SELECT
    i.product_id,
    p.product_name,
    i.quantity
FROM
    products p
INNER JOIN inventories i ON
    p.product_id = i.product_id
WHERE
    product_name LIKE '%Intel%'
ORDER BY
    product_name ASC
    ;