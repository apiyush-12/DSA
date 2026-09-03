# Write your MySQL query statement below
-- select s.user_id,
--     round(sum(case when c.action = "confirmed" then 1 else 0 end) / count(*), 2) as confirmation_rate
-- from Signups as s
-- left join
-- Confirmations as c
-- on s.user_id = c.user_id
-- group by s.user_id
-- order by confirmation_rate


-- SELECT 
--     s.user_id,
--     ROUND(
--         IFNULL(
--             SUM(CASE WHEN c.action = 'confirmed' THEN 1 ELSE 0 END) 
--             / COUNT(c.action),
--             0
--         ),
--         2
--     ) AS confirmation_rate
-- FROM Signups AS s
-- LEFT JOIN Confirmations AS c
-- ON s.user_id = c.user_id
-- GROUP BY s.user_id;



select s.user_id , Round(avg(if(c.action = 'confirmed', 1 , 0)),2) as confirmation_rate 
from Signups s
left join Confirmations c 
on s.user_id = c.user_id
group by s.user_id