SELECT hop_dong.ma_hop_dong,loai_dich_vu.ten_loai_dich_vu, 
		dich_vu_di_kem.ten_dich_vu_di_kem
FROM hop_dong
JOIN hop_dong_chi_tiet 
	ON hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
JOIN dich_vu_di_kem
	ON dich_vu_di_kem.ma_dich_vu_di_kem = hop_dong_chi_tiet.ma_dich_vu_di_kem
JOIN dich_vu
	ON hop_dong.ma_dich_vu = dich_vu.ma_dich_vu
JOIN loai_dich_vu
	ON dich_vu.ma_loai_dich_vu = loai_dich_vu.ma_loai_dich_vu
GROUP BY dich_vu_di_kem.ma_dich_vu_di_kem
HAVING COUNT(dich_vu_di_kem.ma_dich_vu_di_kem) = 1
ORDER BY ma_hop_dong;
