SELECT student.*,MAX(Mark)
FROM student LEFT JOIN mark 
on student.ID_Student = mark.ID_Student
GROUP BY Name_Student
ORDER BY mark DESC;