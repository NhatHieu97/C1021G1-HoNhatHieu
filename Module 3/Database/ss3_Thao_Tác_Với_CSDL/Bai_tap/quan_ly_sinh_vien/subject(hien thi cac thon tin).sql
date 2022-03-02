SELECT * FROM quan_li_sinh_vien.subject; 
select student.ID_Student, student.Name_Student, `subject`.SubName_Subject, mark.Mark
from mark join student on student.ID_Student = mark.ID_Student 
join `subject` on `subject`.SubID_Subject = mark.SubID_Subject
order by mark DESC, Name_Student ASC;
