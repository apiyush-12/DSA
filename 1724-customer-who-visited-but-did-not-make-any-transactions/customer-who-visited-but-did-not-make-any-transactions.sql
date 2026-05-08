-- Write your PostgreSQL query statement below

select v.customer_id, COUNT(*) as count_no_trans
FROM Visits as v
LEFT JOIN
Transactions as t
ON v.visit_id = t.visit_id
where 
t.transaction_id is null
group by customer_id