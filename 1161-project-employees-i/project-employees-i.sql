# Write your MySQL query statement below
Select 
    p.project_id,
      ROUND(Sum(e.experience_years)/Count(p.employee_id),2)  AS average_years
FROM Project p
LEFT JOIN Employee e 
On p.employee_id = e.employee_id
Group by project_id 
