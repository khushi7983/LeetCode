-- When you see “compare with previous/next row” in SQL:
-- If joins are allowed → think self-join on shifted keys.

Select w1.id
From Weather w1
join Weather w2
On DATEDIFF(w1.recordDate, w2.recordDate) = 1
WHERE w1.temperature > w2.temperature;

