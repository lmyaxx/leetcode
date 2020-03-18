# Write your MySQL query statement below
```mysql


select  Day,round((total - completed)/total,2)  `Cancellation Rate`
from
(
    select count(if(trips.Status="completed",1,null)) completed, count(*)  total,  trips.Request_at Day 
    from trips left join users D on D.users_id = trips.Driver_Id  left join users C on C.users_id = trips.Client_id 
    where  trips.Request_at between "2013-10-01" and "2013-10-03" and  C.Banned  = "No" and D.Banned = "No"
    group by trips.Request_at) as census
order by Day;
```