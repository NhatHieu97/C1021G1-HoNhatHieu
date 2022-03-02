SELECT `subject`.*,MAX(Mark)
FROM `subject` JOIN mark 
on `subject`.SubID_Subject = mark.SubID_Subject
GROUP BY SubName_Subject
ORDER BY mark DESC
LIMIT 1;
