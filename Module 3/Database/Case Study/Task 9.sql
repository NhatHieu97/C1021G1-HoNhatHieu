SELECT month(hop_dong.ngay_lam_hop_dong) AS thang, COUNT(ma_khach_hang) AS so_luong_khach_hang
FROM hop_dong
WHERE  year(hop_dong.ngay_lam_hop_dong) = 2021
GROUP BY month(hop_dong.ngay_lam_hop_dong)
ORDER BY month(hop_dong.ngay_lam_hop_dong);