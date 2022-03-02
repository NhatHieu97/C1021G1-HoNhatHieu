SELECT * FROM quan_li_sinh_vien.student;
SELECT * FROM Student WHERE Status_Student = 1;
SELECT concat_ws(",",Name_Student, Name_Class)as infor_student
FROM student as st INNER JOIN class as cl
ON st.ID_Class = cl.ID_Class
WHERE Name_Class = 'A1';
