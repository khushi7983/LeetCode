# Write your MySQL query statement below
SELECT *
FROM Cinema
WHERE description != 'Boring' AND id % 2 = 1 
ORDER by rating DESC;