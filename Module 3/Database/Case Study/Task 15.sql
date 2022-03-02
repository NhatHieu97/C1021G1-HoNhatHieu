SELECT nhan_vien.ma_nhan_vien, nhan_vien.ho_ten, trinh_do.ten_trinh_do, 
		bo_phan.ten_bo_phan, nhan_vien.so_dien_thoai, nhan_vien.dia_chi
FROM nhan_vien
JOIN trinh_do 
	ON nhan_vien.ma_trinh_do = trinh_do.ma_trinh_do
JOIN bo_phan
	ON nhan_vien.ma_bo_phan = bo_phan.ma_bo_phan
GROUP BY nhan_vien.ma_nhan_vien
HAVING COUNT(nhan_vien.ma_nhan_vien) IN (1,2,3)