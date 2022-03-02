SELECT nhan_vien.ma_nhan_vien, nhan_vien.ho_ten
FROM nhan_vien
WHERE ma_nhan_vien IN
(SELECT nhan_vien.ma_nhan_vien
FROM nhan_vien
LEFT JOIN hop_dong
	ON nhan_vien.ma_nhan_vien = hop_dong.ma_nhan_vien
GROUP BY nhan_vien.ma_nhan_vien
HAVING COUNT(hop_dong.ma_nhan_vien) < 1 );

CREATE TEMPORARY TABLE temp
SELECT nhan_vien.ma_nhan_vien
FROM nhan_vien
LEFT JOIN hop_dong
	ON nhan_vien.ma_nhan_vien = hop_dong.ma_nhan_vien
GROUP BY nhan_vien.ma_nhan_vien
HAVING COUNT(hop_dong.ma_nhan_vien) < 1;
SELECT * FROM temp;

DELETE FROM nhan_vien
WHERE ma_nhan_vien IN (SELECT * FROM temp);

DROP TEMPORARY TABLE temp;
