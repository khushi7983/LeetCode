# Write your MySQL query statement below
Select a1.machine_id, Round(Avg(a2.timestamp- a1.timestamp),3) as processing_time
From Activity a1
Inner join Activity a2
On a1.process_id = a2.process_id
And a1.machine_id = a2.machine_id 
And a1.activity_type = "start"
And a2.activity_type = "end"
Group by a1.machine_id