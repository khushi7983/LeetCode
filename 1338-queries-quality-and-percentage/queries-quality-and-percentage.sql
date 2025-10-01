# Write your MySQL query statement below
Select query_name,
Round(AVG(rating/position),2) as quality,
ROUND(COUNT(CASE WHEN rating < 3 THEN 1 END) * 100.0 / COUNT(*), 2) AS poor_query_percentage
From Queries  
Group by query_name
