
SELECT khach_hang.ma_khach_hang, khach_hang.ho_ten, count(hop_dong.ma_hop_dong) AS 'So_lan_dat_phong'
FROM loai_khach JOIN khach_hang on loai_khach.ma_loai_khach = khach_hang.ma_loai_khach
JOIN hop_dong on khach_hang.ma_khach_hang = hop_dong.ma_khach_hang
WHERE ten_loai_khach = 'Diamond'
GROUP BY hop_dong.ma_khach_hang 
ORDER BY So_lan_dat_phong ASC;
