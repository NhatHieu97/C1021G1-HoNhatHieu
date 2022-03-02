SELECT * FROM khach_hang
WHERE (SELECT ROUND(DATEDIFF(CURDATE(), ngay_sinh) / 365, 0))
BETWEEN 18 AND 50
AND (dia_chi LIKE '% Đà Nẵng' OR dia_chi LIKE '% Quảng Trị');



