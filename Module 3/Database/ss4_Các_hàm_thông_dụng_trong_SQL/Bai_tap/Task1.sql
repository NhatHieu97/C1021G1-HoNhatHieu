-- use quan_li_sinh_vien;
SELECT `subject`.*
FROM `subject`
WHERE Credit_Subject = (SELECT Max(Credit_Subject) FROM subject);