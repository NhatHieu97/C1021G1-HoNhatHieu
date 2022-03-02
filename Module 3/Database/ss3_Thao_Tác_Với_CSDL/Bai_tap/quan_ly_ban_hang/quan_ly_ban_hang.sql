CREATE DATABASE quan_ly_ban_hang;
use quan_ly_ban_hang;
CREATE TABLE customer(
c_ID INT PRIMARY KEY,
name_Customer VARCHAR(25),
c_Age TINYINT
);
CREATE TABLE `order`(
o_ID INT PRIMARY KEY,
c_ID INT,
FOREIGN KEY (c_ID) REFERENCES customer(c_ID),
o_Date DATETIME,
o_Total_Price INT
);
CREATE TABLE product(
p_ID INT PRIMARY KEY,
p_name VARCHAR(25),
p_price INT
);
CREATE TABLE orderDetail(
o_ID INT,
p_ID INT,
od_QTY INT
);
INSERT INTO customer
VALUES (1, 'Minh Quan', '10');
INSERT INTO customer
VALUES (2, 'Ngoc Oanh', '20');
INSERT INTO customer
VALUES (3, 'Hong Ha', '50');

INSERT INTO `order`
VALUES (1, 1, '2006/3/21', NULL);
INSERT INTO `order`
VALUES (2, 2, '2006/3/23', NULL);
INSERT INTO `order`
VALUES (3, 1, '2006/3/16', NULL);

INSERT INTO product
VALUES (1, 'May Giat', '3');
INSERT INTO product
VALUES (2, 'Tu Lanh', '5');
INSERT INTO product
VALUES (3, 'Dieu Hoa', '7');
INSERT INTO product
VALUES (4, 'Quat', '1');
INSERT INTO product
VALUES (5, 'Bep Dien', '2');

INSERT INTO orderDetail
VALUES (1, 1, 3),
(1,3,7),
(1,4,2),
(2,1,1),
(3,1,8),
(2,5,4),
(2,3,3);

