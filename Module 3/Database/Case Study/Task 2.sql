USE furama_resort;
SELECT * FROM nhan_vien
WHERE ho_ten LIKE 'H%' OR ho_ten LIKE 'T%' OR ho_ten LIKE 'K%'
AND char_length(ho_ten)<16;