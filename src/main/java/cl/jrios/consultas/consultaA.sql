SELECT
    `product_id`,
    `product_name`,
    `list_price`
FROM
    `products`
WHERE
    `category_id` = 5
ORDER BY
    product_name ASC;