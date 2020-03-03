```
# select distinct num ConsecutiveNums
# from logs aa
# where (select count(*) 
#        from logs bb 
#        where  aa.num = bb.num and (aa.id + 1 = bb.id or aa.id -1 =bb.id)
#        ) > 1
       
select distinct Num as ConsecutiveNums
from Logs
where (Id + 1, Num) in (select * from Logs) and (Id + 2, Num) in (select * from Logs)
```