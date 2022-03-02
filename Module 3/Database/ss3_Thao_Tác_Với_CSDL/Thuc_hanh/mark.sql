use quan_li_sinh_vien;
SELECT * FROM quan_li_sinh_vien.mark;


SELECT s.ID_Student, S.Name_Student, c.Name_Class
FROM student s join Class c
on s.ID_Student = c.ID_Class
WHERE c.Name_Class = 'A1';

SELECT Sub.SubID_Subject, s.Name_Student, Sub.SubName_Subject, m.Mark
FROM student s join mark m
on s.ID_Student = m.ID_Student join Subject Sub 
on m.SubID_Subject = Sub.SubID_Subject
WHERE Sub.SubName_Subject = 'CF';