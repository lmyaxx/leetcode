```mysql
# Write your MySQL query statement below

select Today.Id 
from Weather Today, Weather Yesterday
where Yesterday.RecordDate = date_sub(Today.RecordDate,interval 1 day) and YesterDay.Temperature < Today.Temperature;
```