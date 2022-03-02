USE quan_li_sinh_vien;
SELECT Address_Student, COUNT(ID_Student) AS 'Số lượng học viên'
FROM student
GROUP BY Address_Student;

SELECT S.ID_Student,S.Name_Student, AVG(Mark)
FROM student S join mark M on S.ID_Student = M.ID_Student
GROUP BY S.ID_Student, S.Name_Student;

SELECT S.ID_Student,S.Name_Student, AVG(Mark)
FROM student S join mark M on S.ID_Student = M.ID_Student
GROUP BY S.ID_Student, S.Name_Student
HAVING AVG(Mark) > 15;

SELECT S.ID_Student, S.Name_Student, AVG(Mark)
FROM student S join mark M on S.ID_Student = M.ID_Student
GROUP BY S.ID_Student, S.Name_Student;

SELECT S.ID_Student, S.Name_Student, AVG(Mark)
FROM student S join mark M on S.ID_Student = M.ID_Student
GROUP BY S.ID_Student, S.Name_Student
HAVING AVG(Mark) >= ALL (SELECT AVG(Mark) FROM mark GROUP BY Mark.ID_Student);