# Write your MySQL query statement below
Select r. contest_id,
    Round(100.0 * Count(Distinct r.user_id)/(SELECT COUNT(*) FROM Users),2) as percentage
From Register r
GROUP BY contest_id
ORDER BY percentage DESC, r.contest_id;