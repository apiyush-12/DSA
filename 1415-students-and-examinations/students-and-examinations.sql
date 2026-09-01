-- Write your PostgreSQL query statement below

-- select s.student_id, s.student_name, su.subject_name, 
-- count(e.student_id) as attended_exams
-- from
-- Students as s
-- cross join
-- Subjects as su
-- left join
-- Examinations as e
-- on
-- s.student_id = e.student_id and su.subject_name = e.subject_name
-- group by s.student_id, s.student_name, su.subject_name
-- order by s.student_id, su.subject_name



SELECT s.student_id, s.student_name, ss.subject_name, COUNT(e.student_id) attended_exams
FROM Students s
CROSS JOIN Subjects ss
LEFT JOIN Examinations e 
ON e.subject_name = ss.subject_name AND s.student_id = e.student_id
GROUP BY s.student_id, s.student_name, ss.subject_name, ss.subject_name
ORDER BY s.student_id, ss.subject_name