use quan_ly_ban_hang;
SELECT * FROM quan_ly_ban_hang.customer;
SELECT * FROM quan_ly_ban_hang.`order`;
SELECT * FROM quan_ly_ban_hang.orderdetail;
SELECT * FROM quan_ly_ban_hang.product;
SELECT customer.name_Customer, product.p_name, orderdetail.od_QTY
FROM customer JOIN `order` on customer.c_ID =  `order`.c_ID
JOIN orderdetail on orderdetail.o_ID = `order`.o_ID 
JOIN product on product.p_ID = orderdetail.p_ID;

SELECT customer.name_Customer, product.p_name, orderdetail.od_QTY
FROM customer LEFT JOIN `order` on customer.c_ID =  `order`.c_ID
LEFT JOIN orderdetail on orderdetail.o_ID = `order`.o_ID 
LEFT JOIN product on product.p_ID = orderdetail.p_ID
where orderdetail.od_QTY Is NULL;

SELECT orderdetail.o_ID, `order`.o_Date, SUM(orderdetail.od_QTY * product.p_price) AS 'total price'
 FROM customer JOIN `order` on customer.c_ID =  `order`.c_ID
JOIN orderdetail on orderdetail.o_ID = `order`.o_ID 
JOIN product on product.p_ID = orderdetail.p_ID
GROUP BY orderdetail.o_ID;
