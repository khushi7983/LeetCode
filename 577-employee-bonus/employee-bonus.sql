# Write your MySQL query statement below
Select e.name , b.bonus
From Employee e 
left Join Bonus b 
On e.empId  = b.empId 
where bonus < 1000 or b.bonus IS NULL
order by e.name;