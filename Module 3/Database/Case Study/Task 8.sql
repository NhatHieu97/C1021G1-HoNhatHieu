SELECT khach_hang.ho_ten
FROM khach_hang
UNION
SELECT khach_hang.ho_ten
FROM khach_hang;
SELECT DISTINCT khach_hang.ho_ten
FROM khach_hang;
SELECT khach_hang.ho_ten
FROM khach_hang
GROUP BY ho_ten;